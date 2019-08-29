package Exercise;

/**
 * Created by wangnan01 on 2017/11/2.
 */
public class TypeTest {
    public static void main(String[] args) {
        byte a1 = 2, a2 = 4, a3;
        short s = 16;
        a2 = (byte) s;
        a3 = (byte) (a1 *a2);
    }
}
