package Thread.learn.Yishu;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by wangnan01 on 2019/8/1.
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    System.out.println(1);
                }
            }
        }).start();
        try {
            c.wait();
        } catch (Exception e) {
            System.out.println(2);
        }
    }
}
