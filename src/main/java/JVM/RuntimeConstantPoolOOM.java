package JVM;

/**
 * Created by wangnan01 on 2017/10/17.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String s1 = new StringBuilder("我").append("ni").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
