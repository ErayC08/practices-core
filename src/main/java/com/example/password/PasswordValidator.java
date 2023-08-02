package com.example.password;

import java.util.*;

public class PasswordValidator {

    public static Stack<PasswordRule> getBrokenRules(String password, Set<PasswordRule> passwordRules) {
        if (passwordRules.contains(PasswordRule.HAS_VALID_LENGTH)) {
            throw new PasswordValidatorException("Use this method with 'minLength' and 'maxLength' parameters in order to check the length");
        }
        Map<PasswordRule, Boolean> passwordRuleBooleanMap = updatePasswordRuleBooleanMap(password, buildPasswordRuleBooleanMap(passwordRules));

        return findBrokenRules(passwordRuleBooleanMap);
    }

    public static Stack<PasswordRule> getBrokenRules(String password, Set<PasswordRule> passwordRules, int minLength) {
        Stack<PasswordRule> brokenRules = getBrokenRules(password, passwordRules);

        if (password.length() < minLength) {
            brokenRules.push(PasswordRule.HAS_VALID_LENGTH);
        }
        return brokenRules;
    }

    public static Stack<PasswordRule> getBrokenRules(String password, Set<PasswordRule> passwordRules, int minLength, int maxLength) {
        Stack<PasswordRule> brokenRules = getBrokenRules(password, passwordRules);

        if (password.length() < minLength || maxLength < password.length()) {
            brokenRules.push(PasswordRule.HAS_VALID_LENGTH);
        }
        return brokenRules;
    }

    public static boolean isValid(String password, Set<PasswordRule> passwordRules) {
        return getBrokenRules(password, passwordRules).empty();
    }

    public static boolean isValid(String password, Set<PasswordRule> passwordRules, int minLength) {
        return getBrokenRules(password, passwordRules, minLength).empty();
    }

    public static boolean isValid(String password, Set<PasswordRule> passwordRules, int minLength, int maxLength) {
        return getBrokenRules(password, passwordRules, minLength, maxLength).empty();
    }

    private static Map<PasswordRule, Boolean> buildPasswordRuleBooleanMap(Set<PasswordRule> passwordRules) {
        Map<PasswordRule, Boolean> passwordRuleBooleanMap = new HashMap<>();

        for (PasswordRule passwordRule : PasswordRule.values()) {
            if (passwordRules.contains(passwordRule)) {
                passwordRuleBooleanMap.put(passwordRule, false);
            } else {
                passwordRuleBooleanMap.put(passwordRule, true);
            }
        }
        return passwordRuleBooleanMap;
    }

    private static Map<PasswordRule, Boolean> updatePasswordRuleBooleanMap(String password, Map<PasswordRule, Boolean> passwordRuleBooleanMap) {
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
        return passwordRuleBooleanMap;
    }

    private static Stack<PasswordRule> findBrokenRules(Map<PasswordRule, Boolean> passwordRuleBooleanMap) {
        Stack<PasswordRule> brokenRules = new Stack<>();

        for (Map.Entry<PasswordRule, Boolean> entry : passwordRuleBooleanMap.entrySet()) {
            if (!entry.getValue()) {
                brokenRules.push(entry.getKey());
            }
        }
        return brokenRules;
    }
}
