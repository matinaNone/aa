package Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangnan01 on 2017/12/1.
 */
public class ListRetainTest {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        l1.add("1");
        l1.add("2");
        l1.add("3");
        l2.add("2");
        l2.add("3");
        l2.add("4");
        l1.retainAll(l2);
        System.out.println(l1);
    }
}
