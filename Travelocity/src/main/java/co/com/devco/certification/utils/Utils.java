package co.com.devco.certification.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String getDateFromToday(int numberOfDays, String format){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format, Locale.US);
        LocalDateTime now = LocalDateTime.now().plusDays(numberOfDays);

        return  dtf.format(now);
    }

    public static List<String> getTimeSplatted(String time){

        Pattern p = Pattern.compile("(^[0-9]*):([0-9]*)([ap][m])");
        Matcher m = p.matcher(time);

        m.find();

        String departureHour = m.group(1);
        String departureMinutes = m.group(2);
        String departureTime = m.group(3);

        return Arrays.asList(departureHour, departureMinutes, departureTime);
    }

}
