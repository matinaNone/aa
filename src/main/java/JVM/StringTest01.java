package JVM;

/**
 * Created by wangnan01 on 2017/10/17.
 */
public class StringTest01 {
    public static void main(String[] args) {
        String baseStr = "baseStr";
        final String baseFinalStr = "baseStr";

        String str1 = "baseStr01";
        String str2 = "baseStr" + "01";
        String str3 = baseStr + "01";
        String str4 = baseFinalStr + "01";
        String str5 = new String("baseStr01").intern();


        System.out.println(str1 == str2);//#3 true
        System.out.println(str1 == str3);//#4 false
        System.out.println(str1 == str4);//#5 true
        System.out.println(str1 == str5);//#6 true
        System.out.println(baseFinalStr == baseStr); //true
        System.out.println(str2 == str3); //false
        System.out.println(str2 == str4); //true
        System.out.println(str3 == str4); //false
    }
}
