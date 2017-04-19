package com.hotel;

import java.util.List;

public class PasswordValidator {

    public static void validateCustomerPassword(String password, List<String> errors) {
        if (password.trim().length() < 8) {
            errors.add("Minimale lengte is 8 karakters.");
        }
        if (countDigits(password) < 1) {
            errors.add("Minimaal 1 getal vereist.");
        }
        if (countLowerCaseCharacters(password) < 1) {
            errors.add("Minimaal 1 kleine letter vereist.");
        }
        if (countUpperCaseCharacters(password) < 1) {
            errors.add("Minimaal 1 hoofdletter letter vereist.");
        }
    }

    public static void validateEmployeePassword(String password, List<String> errors) {
        if (password.trim().length() < 10) {
            errors.add("Minimale lengte is 10 karakters.");
        }
        if (countDigits(password) < 1) {
            errors.add("Minimaal 1 getal vereist.");
        }
        if (countLowerCaseCharacters(password) < 1) {
            errors.add("Minimaal 1 kleine letter vereist.");
        }
        if (countUpperCaseCharacters(password) < 1) {
            errors.add("Minimaal 1 hoofdletter letter vereist.");
        }
        if (countSpecialCharacters(password) < 1) {
            errors.add("Minimaal 1 bijzonder teken, toegestaan zijn: !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
        }
    }

    /**
     * Allowed special chars: ascii 33-47 + 58-64 + 91-96 + 123-126 = !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
     *
     * See: https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
     */
    private static int countSpecialCharacters(String text) {
        int count = 0;
        for (char a : text.toCharArray()) {
            if (a > 32 && a < 48 || a > 57 && a < 65 || a > 90 && a < 97 || a > 122 && a < 127) {
                count++;
            }
        }
        return count;
    }

    private static int countLowerCaseCharacters(String text) {
        int count = 0;
        for (char a : text.toCharArray()) {
            if (Character.isLowerCase(a)) {
                count++;
            }
        }
        return count;
    }

    private static int countUpperCaseCharacters(String text) {
        int count = 0;
        for (char a : text.toCharArray()) {
            if (Character.isUpperCase(a)) {
                count++;
            }
        }
        return count;
    }

    private static int countDigits(String text) {
        int count = 0;
        for (char a : text.toCharArray()) {
            if (Character.isDigit(a)) {
                count++;
            }
        }
        return count;
    }
}