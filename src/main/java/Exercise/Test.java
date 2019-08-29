package Exercise;

/**
 * Created by wangnan01 on 2017/11/2.
 */
public class Test {
    static {
        int x = 5;
    }

    static int x, y;

    public static void main(String args[]) {
        x--;
        myMethod();
        System.out.println(x + y + ++x);
    }

    public static void myMethod() {
        y = x++ + ++x;
    }
}
