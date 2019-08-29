package List;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangnan01 on 2018/5/31.
 */
public class InsertTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = list;


        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i));
            if (3 == list.get(i)){
                list1.add(7);
            }
        }

//        list2.removeAll(list1);
//        list1.add(7);
//        list1.addAll(list2);
        System.out.println(list1);

    }
}
