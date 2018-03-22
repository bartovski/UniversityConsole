package com.burkovskiy.university.console.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHolder {

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
