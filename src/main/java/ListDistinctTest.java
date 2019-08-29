import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangnan01 on 2018/1/12.
 */
public class ListDistinctTest {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("1");
        a.add("1");
        System.out.println(a);

//        a.stream().distinct().collect(Collectors.toList());
        a.stream().map(i -> {i = "2"; return i;}).collect(Collectors.toList());
//        System.out.println(a.stream().distinct().count());
        System.out.println(a);
    }
}
