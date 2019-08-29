package Thread.learn.Yishu;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangnan01 on 2019/7/8.
 */
public class SleepUtil {
    static final void second(long second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
