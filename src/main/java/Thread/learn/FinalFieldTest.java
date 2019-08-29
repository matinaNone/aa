package Thread.learn;

/**
 * Created by wangnan01 on 2019/8/22.
 */
public class FinalFieldTest {
    final int x;
    int y;
    static FinalFieldTest f;
    public FinalFieldTest() {
        x = 3;
        y = 4;
    }

    static void writer() {
        f = new FinalFieldTest();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;
            int j = f.y;
        }
    }
}
