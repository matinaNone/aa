import com.google.gson.Gson;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fulg on 2017/8/29.
 */
public class ThreeKingdomsPowerCalcTest {


    @Test
    public void test() {

        double wei = 488499;
        double shu = 488498;
        double wu = 23300;

        double sum = wei + shu + wu;

        double step = 1D / 19D; //步长，每增一座城市增加的百分比

        int totalNum = 20;
        if(sum == 0){
            List result = Arrays.asList(0,0,0);
            System.out.println(result);
            return;
        }
        long wei_l = new BigDecimal(Double.toString(wei / sum * 1.0E+17)).setScale(0,
            BigDecimal.ROUND_HALF_UP).longValue();
        long shu_l = new BigDecimal(Double.toString(shu / sum * 1.0E+17)).setScale(0,
            BigDecimal.ROUND_HALF_UP).longValue();
        long wu_l = new BigDecimal(Double.toString(wu / sum * 1.0E+17)).setScale(0,
            BigDecimal.ROUND_HALF_UP).longValue();
        //计算比例，保留两位小数
        String wei_d = String.format("%.2f",new BigDecimal(wei_l / 1.0E+15).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        String shu_d = String.format("%.2f",new BigDecimal(shu_l / 1.0E+15).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        String wu_d = String.format("%.2f",new BigDecimal(wu_l / 1.0E+15).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        long step_l = new BigDecimal(Double.toString(step * 1.0E+17)).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();

        System.out.println("step_l = " + step_l);

        System.out.println("wei_l:" + wei_l);
        System.out.println("shu_l:" + shu_l);
        System.out.println("wu_l:" + wu_l);

        System.out.println("wei_d:" + wei_d);
        System.out.println("shu_d:" + shu_d);
        System.out.println("wu_d:" + wu_d);

        int wei_i = new BigDecimal(Double.toString((wei_l + (step_l - 1)) / step_l)).setScale(0,
            BigDecimal.ROUND_HALF_UP).intValue();
        int shu_i = new BigDecimal(Double.toString((shu_l + (step_l - 1)) / step_l)).setScale(0,
            BigDecimal.ROUND_HALF_UP).intValue();
        int wu_i = new BigDecimal(Double.toString((wu_l + (step_l - 1)) / step_l)).setScale(0,
            BigDecimal.ROUND_HALF_UP).intValue();

        System.out.println("wei_i: " + wei_i);
        System.out.println("shu_i: " + shu_i);
        System.out.println("wu_i: " + wu_i);


        List<ThreeKingdomsPower> list = Arrays.asList(new ThreeKingdomsPower(1, wei_i, wei_l,wei_d),
            new ThreeKingdomsPower(2, shu_i,shu_l,shu_d),new ThreeKingdomsPower(3, wu_i,wu_l,wu_d));

        list.sort(
            new Comparator<ThreeKingdomsPower>() {
                @Override
                public int compare(ThreeKingdomsPower o1, ThreeKingdomsPower o2) {
//                    System.out.println(o1.getKingdomNum() + " " + o1.getPower() + " " + o1.getPowelv());
//                    System.out.println(o2.getKingdomNum() + " " + o2.getPower() + " " + o2.getPowelv());
                    if (o1.getPower() == o2.getPower()) {
                        if(o1.getKingdomNum()==3){
                            return -1;
                        }else {
                            if(o1.getPowelv() < o2.getPowelv()){
                                return -1;
                            }else if(o1.getPowelv() == o2.getPowelv()){
                                return 0;
                            }
                            return 1;
                        }
                    } else if (o1.getPower() > o2.getPower()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        );

        System.out.println("1");
        for (ThreeKingdomsPower t: list){
            System.out.println(t.getKingdomNum() + " " + t.getPower() + " " + t.getPowelv());
        }

        list.get(0).setPower(totalNum - (list.get(1).getPower() + list.get(2).getPower()));
        //比例第二名的 = 100 - 比例最大的 - 比例最小的
        list.get(0).setRatioString(String.format("%.2f", new BigDecimal("100").subtract(new BigDecimal(list.get(1).getRatioString())).subtract(new BigDecimal(list.get(2).getRatioString()))));

        list.sort(
            new Comparator<ThreeKingdomsPower>() {
                @Override
                public int compare(ThreeKingdomsPower o1, ThreeKingdomsPower o2) {

                    if (o1.getKingdomNum() == o2.getKingdomNum()) {
                        return 0;
                    } else if (o1.getKingdomNum() > o2.getKingdomNum()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        );

        List list_rst = list.stream().map(ThreeKingdomsPower::getPower).collect(Collectors.toList());
        List<String> cityRatio = list.stream().map(ThreeKingdomsPower::getRatioString).collect(Collectors.toList());
        System.out.println(list_rst);
        System.out.println(cityRatio);
    }

    public class ThreeKingdomsPower {

        int kingdomNum;
        int power;
        long powelv;
        private String ratioString;

        public int getKingdomNum() {
            return kingdomNum;
        }

        public void setKingdomNum(int kingdomNum) {
            this.kingdomNum = kingdomNum;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public long getPowelv() {
            return powelv;
        }

        public void setPowelv(long powelv) {
            this.powelv = powelv;
        }

        public String getRatioString() {
            return ratioString;
        }

        public void setRatioString(String ratioString) {
            this.ratioString = ratioString;
        }

        public ThreeKingdomsPower(int kingdomNum, int power, long powelv, String ratioString) {
            this.kingdomNum = kingdomNum;
            this.power = power;
            this.powelv = powelv;
            this.ratioString = ratioString;
        }
    }

}
