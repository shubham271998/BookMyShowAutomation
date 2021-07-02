package Automation.BookMyShow;

import java.util.Date;

//class will return date format mentioned
public class DateUtils {

    public static String getTimeStamp(){
        Date date = new Date();
        return date.toString().replaceAll(":","_").replaceAll(" ","_");
    }
}
