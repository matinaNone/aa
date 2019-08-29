package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by wangnan01 on 2017/10/21.
 */
public class DateBetween {
    public static void main(String[] args) throws ParseException {
        List<Integer> list1 = daysBetween("2017-10-30 00:00:00","2018-7-23 00:00:00");
        List<Integer> list2 = daysBetween("1984-11-2 00:00:00","2017-10-26 00:00:00");
        System.out.println(list1);
        System.out.println(list2);
    }
    public static List<Integer> daysBetween(String smdate, String bdate) throws ParseException {
        List<Integer> list = new ArrayList<>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        int day =  Integer.parseInt(String.valueOf(between_days));
        System.out.println("day: " + day);
        int mode1 = day%23;
        int mode2 = day%28;
        int mode3 = day%33;
        list.add(mode1);
        list.add(mode2);
        list.add(mode3);
        return list;
    }
}
