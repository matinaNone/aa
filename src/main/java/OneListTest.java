import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangnan01 on 2017/9/26.
 */
public class OneListTest {
    public static void main(String[] args) {
        List<Integer> all = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        all.add(1);
        all.add(1);
        all.add(3);
        all.add(4);
        all.add(5);
        all.add(6);

        l1.add(1);
        l1.add(3);
        l1.add(4);

        all.removeAll(l1);
        all.addAll(l1);
        System.out.println(all);
    }
}
