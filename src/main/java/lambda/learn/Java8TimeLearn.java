package lambda.learn;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.IsoChronology;

/**
 * Created by wangnan01 on 2017/5/24.
 * 
 */
public class Java8TimeLearn {
    public static void main(String[] args) {
        LocalDate localDate = IsoChronology.INSTANCE.date(1989, 7, 18);
        Period period = localDate.until(IsoChronology.INSTANCE.dateNow());
        System.out.println(localDate);
        System.out.println(period);
        System.out.println(period.getYears());
    }
}
