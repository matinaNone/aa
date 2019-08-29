package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangnan01 on 2017/10/18.
 */
public class StringOomMock {
    static String base = "string";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
            System.out.println(i);
        }
    }
}
