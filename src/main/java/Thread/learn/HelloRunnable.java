package Thread.learn;

/**
 * Created by wangnan01 on 2017/7/14.
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hhhhhhh");
    }

    public static void main(String[] args) {
        new Thread(new HelloRunnable()).start();
    }
}
