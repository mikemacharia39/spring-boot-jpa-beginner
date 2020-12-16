package com.mikehenry.springbootjpabeginner.Utils;

public class Utilities {

    /**
     * To check if a value is empty or null
     * @param value Object being determined
     * @return boolean true|false
     */
    public static boolean isEmpty(Object value) {
        boolean isEmpty = false;
        if (value == null || value.toString().replaceAll("\\s", String.valueOf(value)).equals("")) {
            isEmpty = true;
        }
        return isEmpty;
    }
}
