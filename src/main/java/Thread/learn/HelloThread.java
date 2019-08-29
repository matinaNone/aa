package Thread.learn;

/**
 * Created by wangnan01 on 2017/7/14.
 */
public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("ttttttttttttt");
    }

    public static void main(String[] args) {
        (new HelloThread()).start();
    }
}
