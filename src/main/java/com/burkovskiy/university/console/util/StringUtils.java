package com.burkovskiy.university.console.util;

public class StringUtils {

    public static String removeDot(String str) {
        if (str.endsWith(".")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }
}
