package Decimal;

import java.math.BigDecimal;

/**
 * Created by wangnan01 on 2017/12/2.
 */
public class DecimalTest2 {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("3");
        BigDecimal b2 = new BigDecimal("8");
        BigDecimal b3 = b2.divide(b1).multiply(new BigDecimal("2.00"));
//        b1.add(b2);
        System.out.println(b3.toString());
    }
}
