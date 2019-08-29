import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangnan01 on 2017/8/30.
 */
public class TwoListTest {
    public static void main(String[] args) {
        List<SkuDeductAutumn> list1 = new ArrayList<>();
        SkuDeductAutumn s1 = new SkuDeductAutumn("s1", 1);
        SkuDeductAutumn s2 = new SkuDeductAutumn("s1", 1);
        SkuDeductAutumn s7 = new SkuDeductAutumn("s1", 1);
        list1.add(s1);
        list1.add(s2);
        list1.add(s7);
        System.out.println(list1);

//        List<SkuDeductAutumn> list2 = new ArrayList<>();
//        SkuDeductAutumn s3 = new SkuDeductAutumn("s1", 1);
//        SkuDeductAutumn s4 = new SkuDeductAutumn("s1", 2);
//        SkuDeductAutumn s5 = new SkuDeductAutumn("s2", 2);
//        SkuDeductAutumn s6 = new SkuDeductAutumn("s2", 3);
//        SkuDeductAutumn s8 = new SkuDeductAutumn("s3", 4);
//        SkuDeductAutumn s9 = new SkuDeductAutumn("s3", 5);
//        list2.add(s3);
//        list2.add(s4);
//        list2.add(s5);
//        list2.add(s6);
//        list2.add(s8);
//        list2.add(s9);

//        boolean flag = true;
//        for(SkuDeductAutumn skuDeductAutumn1 : list1){
//            String skuId = skuDeductAutumn1.getSkuId();
//            int ruleId = skuDeductAutumn1.getRuleId();
//            System.out.println(skuId);
//            List<Integer> ruleIdList = list2.stream()
//                    .filter(s->s.getSkuId()
//                            .equals(skuId)).map(SkuDeductAutumn::getRuleId).collect(Collectors.toList());
//            System.out.println(ruleIdList);
//            if(!ruleIdList.contains(ruleId)){
//               flag = false;
//               break;
//            }
//        }
//
//        System.out.println(flag);
    }
}
