package com.sample.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate {

    private CurrentDate() {

    }

    public static String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
        Date date = new Date();
        return formatter.format(date);

    }

    public static String CurrentDateOnly()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date currDate = new Date();
        return formatter.format(currDate);
    }

    public static String CurrentTimeOnly()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH PM-mm");
        Date currTime = new Date();
        return formatter.format(currTime);

    }
}
