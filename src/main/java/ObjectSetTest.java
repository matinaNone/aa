import lambda.learn.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wangnan01 on 2018/6/4.
 */
public class ObjectSetTest {
    public static void main(String[] args) {

        List<SkuDeductAutumn> l = new ArrayList<>();

        SkuDeductAutumn s1 = null;


        SkuDeductAutumn s2 = new SkuDeductAutumn();
        s2.setSkuId("s2");
        s2.setB1(new BigDecimal("1"));


        SkuDeductAutumn s3 = new SkuDeductAutumn();
        s3.setSkuId("s3");
        s3.setB1(new BigDecimal("3"));

        l.add(s1);
        l.add(s2);
        l.add(s3);

        String s = s3.getSkuId();
        s = "s33";

        System.out.println(s1);

//        SkuDeductAutumn max = Collections.max(l, Comparator.comparing(SkuDeductAutumn::getB1));
//        System.out.println(max.getB1());
//
//        SkuDeductAutumn min = Collections.min(l, Comparator.comparing(SkuDeductAutumn::getB1));
//        System.out.println(min.getSkuId() + " " + min.getB1());

    }
}
