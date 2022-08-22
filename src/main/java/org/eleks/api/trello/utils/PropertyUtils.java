package org.eleks.api.trello.utils;

import java.util.Properties;

public class PropertyUtils {
    public static String getBASE_URL(String property){
//        return System.getProperty("host");
        return System.getenv("BASE_URL");
    }
}
