package co.com.devco.certification.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utils {

    public static String getDateFromToday(int numberOfDays){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.US);
        LocalDateTime now = LocalDateTime.now().plusDays(numberOfDays);

        return  dtf.format(now);
    }

}
