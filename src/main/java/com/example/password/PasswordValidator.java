package com.example.password;

import java.util.*;

public class PasswordValidator {

    public static Set<PasswordRule> findBrokenRules(String password) {
        Map<PasswordRule, Boolean> passwordRuleBooleanMap = initializePasswordRuleBooleanMap();

        processPasswordRuleBooleanMap(password, passwordRuleBooleanMap);

        return extractBrokenRules(passwordRuleBooleanMap);
    }

    public static Set<PasswordRule> findBrokenRules(String password, int minLength) {
        Map<PasswordRule, Boolean> passwordRuleBooleanMap = initializePasswordRuleBooleanMap();

        processPasswordRuleBooleanMap(password, passwordRuleBooleanMap, minLength);

        return extractBrokenRules(passwordRuleBooleanMap);
    }

    public static Set<PasswordRule> findBrokenRules(String password, int minLength, int maxLength) {
        Map<PasswordRule, Boolean> passwordRuleBooleanMap = initializePasswordRuleBooleanMap();

        processPasswordRuleBooleanMap(password, passwordRuleBooleanMap, minLength, maxLength);

        return extractBrokenRules(passwordRuleBooleanMap);
    }

    private static Map<PasswordRule, Boolean> initializePasswordRuleBooleanMap() {
        Map<PasswordRule, Boolean> passwordRuleBooleanMap = new HashMap<>();

        for (PasswordRule passwordRule : PasswordRule.values()) {
            passwordRuleBooleanMap.put(passwordRule, false);
        }
        return passwordRuleBooleanMap;
    }

    private static void processPasswordRuleBooleanMap(String password, Map<PasswordRule, Boolean> passwordRuleBooleanMap) {
        String specialChars = "~`!@#$%^&*()-_=+\\\\|[{]};:'\\\",<.>/?";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                passwordRuleBooleanMap.put(PasswordRule.CONTAINS_DIGIT, true);
            } else if (Character.isLowerCase(c)) {
                passwordRuleBooleanMap.put(PasswordRule.CONTAINS_LOWERCASE, true);
            } else if (Character.isUpperCase(c)) {
                passwordRuleBooleanMap.put(PasswordRule.CONTAINS_UPPERCASE, true);
            } else if (specialChars.contains(String.valueOf(c))) {
                passwordRuleBooleanMap.put(PasswordRule.CONTAINS_SPECIAL_CHARACTER, true);
            }
        }
        passwordRuleBooleanMap.put(PasswordRule.HAS_VALID_LENGTH, true);
    }

    private static void processPasswordRuleBooleanMap(String password, Map<PasswordRule, Boolean> passwordRuleBooleanMap, int minLength) {
        processPasswordRuleBooleanMap(password, passwordRuleBooleanMap);

        if (password.length() < minLength) {
            passwordRuleBooleanMap.put(PasswordRule.HAS_VALID_LENGTH, false);
        }
    }

    private static void processPasswordRuleBooleanMap(String password, Map<PasswordRule, Boolean> passwordRuleBooleanMap, int minLength, int maxLength) {
        processPasswordRuleBooleanMap(password, passwordRuleBooleanMap);

        if (password.length() < minLength || maxLength < password.length()) {
            passwordRuleBooleanMap.put(PasswordRule.HAS_VALID_LENGTH, false);
        }
    }

    private static Set<PasswordRule> extractBrokenRules(Map<PasswordRule, Boolean> passwordRuleBooleanMap) {
        Set<PasswordRule> brokenRules = new HashSet<>();

        for (Map.Entry<PasswordRule, Boolean> entry : passwordRuleBooleanMap.entrySet()) {
            if (!entry.getValue()) {
                brokenRules.add(entry.getKey());
            }
        }
        return brokenRules;
    }
}
