package org.fasttrackit.bloodpressuremanager.util;

public class CheckUtils {

    public static void checkStringIsNotNull(String stringToCheck, String element) {
        //check if a sting is null
        if (stringToCheck == null) {
            //if the string is null throw an exception
            throw new IllegalArgumentException(element+" can NOT be null");
        }
    }

    public static void checkLongElementIsNotNull(long longElementToCheck, String element) {
        //check if a long element is null
        if (longElementToCheck == Long.parseLong(null)) {
            //if the element is null throw an exception
            throw new IllegalArgumentException(element+" can NOT be null");
        }
    }
}
