import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wangnan01 on 2017/8/30.
 */
public class ListTestTow {
    public static void main(String[] args) {

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();

        l1.add("s1");
        l1.add("s1");
        l1.add("s2");
        l1.add("s2");
        l1.add("s3");


        l2.add("s2");
        l2.add("s3");
        l2.add("s4");

//        l1.remove("s2");
        l1.add("s2");

        Map<String,Long> skuAndNumMap = l1.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting())) ;


//        l1.retainAll(l2);

        System.out.println(skuAndNumMap);
    }
}
