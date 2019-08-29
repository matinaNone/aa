import com.google.gson.Gson;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by wangnan01 on 2017/8/14.
 */
public class MallStringTest {
    private static Gson gson=new Gson();

    public static void main(String[] args) {
        String s = "ab一二三四六七吧";

//        System.out.println(s.trim());
//        System.out.println(filter(s));
        int i = 1;
        List<Double> l = getDigitalLotterySanGuoWei();
        System.out.println(l);
        double a = i;
        System.out.println(l.contains(a));

    }

    public static String filter(String str) {
        String regEx = "[`~!@$%^&*\\-+={}':;,\\[\\].<>/?￥%…（）_+|【】‘；：”“’。，、？\\s  ]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static List<Double> getDigitalLotterySanGuoWei() {
        List<Double> list=gson.fromJson("[1,2,3,4,5,6,7]",List.class);
        System.out.println(list);
        System.out.println(list.get(0));
//        List<Integer> l =  list.stream().map(n -> Integer.parseInt(n)).collect(Collectors.toList());
        return list;
    }
}
