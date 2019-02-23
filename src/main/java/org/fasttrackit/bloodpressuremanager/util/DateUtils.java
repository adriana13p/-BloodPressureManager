package org.fasttrackit.bloodpressuremanager.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date formatStringToDate(String stringToFormat) {
        //format a string into date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date dateToUse = null;
        try {
            dateToUse = formatter.parse(stringToFormat);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Date could not be converted");
        }
        return dateToUse;
    }
}
