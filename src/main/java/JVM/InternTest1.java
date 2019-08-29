package JVM;

/**
 * Created by wangnan01 on 2017/10/18.
 */
public class InternTest1 {
    public static void main(String[] args) {
        String str1 = "str01";
        String str2 = new String("str") + new String("01");
        str2.intern();
        System.out.println(str2 == str1);//#8
    }
}
