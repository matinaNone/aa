import java.math.BigDecimal;

/**
 * Created by wangnan01 on 2017/8/31.
 */
public class WeightTest {

    private static String proportionResult(String part, String total, String calculatePart){
        BigDecimal partBig = new BigDecimal(part);
        BigDecimal totalBig = new BigDecimal(total);
        BigDecimal calculatePartBig = new BigDecimal(calculatePart);
        BigDecimal weight = partBig.divide(totalBig, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("weight: " + weight);
        BigDecimal resultBig = weight.multiply(calculatePartBig).setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println("resultBig: " + resultBig);
        return resultBig.toString();
    }

    public static void main(String[] args) {
        String part = "31";
        String total = "70";
        String calculatePart = "10";

        proportionResult(part,total,calculatePart);
    }

}
