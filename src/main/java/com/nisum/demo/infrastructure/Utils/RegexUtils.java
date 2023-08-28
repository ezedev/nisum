package com.nisum.demo.infrastructure.Utils;

public class RegexUtils {

    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }
}
