package Exercise;

/**
 * Created by wangnan01 on 2017/11/6.
 */
public class StringTest {
    public static void change(String s){
        s = "abc";
    }

    public static void main(String[] args) {
        String s = "a";
        change(s);
        System.out.println(s);
    }
}
