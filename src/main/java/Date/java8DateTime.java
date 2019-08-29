package Date;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by wangnan01 on 2018/1/15.
 */
public class java8DateTime {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        int nano = localDateTime.getNano();
        System.out.println("nano: "+ nano);

        System.out.println(localDateTime.toLocalDate());
        LocalDate ld = LocalDate.now();
        System.out.println(ld.atTime(0,0));


        LocalTime localTime = LocalTime.of(0, 0);
        System.out.println("=== "+localTime);
        LocalTime localTime0 = LocalTime.of(0, 0);
        LocalTime localTime2 = LocalTime.of(2, 0);
        LocalTime localTime24 = LocalTime.of(23, 59, 59, 999000000);
        System.out.println(localTime0);
        System.out.println(localTime2);
        System.out.println("localTime24: " + localTime24);

//        System.out.println( (localTime.isAfter(localTime0)||localTime.equals(localTime0)) && (localTime.isBefore(localTime2)||localTime.equals(localTime2)));
        System.out.println(localTime.compareTo(localTime0)>=0);
        System.out.println(localTime.compareTo(localTime2)<=0);


        if(localTime.isAfter(localTime0) && localTime.isBefore(localTime2)){
            System.out.println(1);
        }


        LocalDateTime createTime = LocalDateTime.parse("2017-06-13 10:45:15".replace(" ", "T"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(createTime);
        LocalDate createDate = LocalDate.parse("2017-06-13 10:45:15".substring(0,10).replace("-",""), DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(createDate);



    }
}
