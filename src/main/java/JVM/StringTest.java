package JVM;

/**
 * Created by wangnan01 on 2017/10/17.
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "string";
        String str2 = new String("string");
        String str3 = str2.intern();

        System.out.println(str1==str2);//#1
        System.out.println(str1==str3);//#2
        System.out.println(str2==str3);

        Object o = new Object();
    }
}
