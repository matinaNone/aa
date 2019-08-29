package Thread.learn.Yishu;

/**
 * Created by wangnan01 on 2019/7/8.
 */
public class ThreadState {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        new Thread(new Bolcked(), "BlockedThread-1").start();
        new Thread(new Bolcked(), "BlockedThread-2").start();

    }

    static class TimeWaiting implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtil.second(100);
            }
        }
    }

    static class Waiting implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Bolcked implements Runnable{

        @Override
        public void run() {
            synchronized (Bolcked.class){
                while (true){
                    SleepUtil.second(100);
                }
            }
        }
    }
}
