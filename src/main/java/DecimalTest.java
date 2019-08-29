import java.math.BigDecimal;

/**
 * Created by wangnan01 on 2017/7/12.
 *
 */
public class DecimalTest {
    public static void main(String[] args) {
        BigDecimal priceCurrentWh = new BigDecimal(0);
        priceCurrentWh = priceCurrentWh.add(new BigDecimal(0.01).multiply(new BigDecimal(498)));

        String a = "0.01";
        String n = "2";
        float e = 0.01f;
        int i = 2;
        double d = 0.01;
        BigDecimal b1 = new BigDecimal(0);
        b1 = b1.add(new BigDecimal(a).multiply(new BigDecimal(i)));

        BigDecimal b2 = new BigDecimal(0);
        b2 = b2.add(new BigDecimal(e).multiply(new BigDecimal(i)));

        BigDecimal c = new BigDecimal(0);
        c = c.add(new BigDecimal(d).multiply(new BigDecimal(i)));

        System.out.println(priceCurrentWh.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP));
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(c);
    }

    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
