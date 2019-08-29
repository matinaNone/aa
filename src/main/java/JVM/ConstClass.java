package JVM;

/**
 * Created by wangnan01 on 2017/11/20.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD ="hello world!";
}
