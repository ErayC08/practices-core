package com.example.password;

import java.util.Set;

public class PasswordValidatorExecutor {

    public static Set<PasswordRule> findConcernedBrokenRules(String password, Set<PasswordRule> concernedRules) {
        Set<PasswordRule> brokenRules = PasswordValidator.findBrokenRules(password);

        return filterBrokenRules(brokenRules, concernedRules);
    }

    public static Set<PasswordRule> findConcernedBrokenRules(String password, int minLength, Set<PasswordRule> concernedRules) {
        Set<PasswordRule> brokenRules = PasswordValidator.findBrokenRules(password, minLength);

        return filterBrokenRules(brokenRules, concernedRules);
    }

    public static Set<PasswordRule> findConcernedBrokenRules(String password, int minLength, int maxLength, Set<PasswordRule> concernedRules) {
        Set<PasswordRule> brokenRules = PasswordValidator.findBrokenRules(password, minLength, maxLength);

        return filterBrokenRules(brokenRules, concernedRules);
    }

    private static Set<PasswordRule> filterBrokenRules(Set<PasswordRule> brokenRules, Set<PasswordRule> concernedRules) {

        //If concerned rules does not include the broken rule, then remove it from the broken rules.
        brokenRules.removeIf(next -> !concernedRules.contains(next));
        return brokenRules;
    }
}
