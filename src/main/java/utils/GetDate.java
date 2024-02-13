package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDate {
    public static String setDaysToAdd(String format,int daysToAdd) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);
        Date newDate = calendar.getTime();
        return formatter.format(newDate);
    }
}
