package lambda.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangnan01 on 2018/1/17.
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);

        List<Integer> l3 = l.stream().filter(integer -> !l2.contains(integer)).collect(Collectors.toList());

        System.out.println(l);
        System.out.println(l3);

    }
}
