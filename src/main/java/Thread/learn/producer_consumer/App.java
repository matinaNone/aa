package Thread.learn.producer_consumer;

/**
 * Created by wangnan01 on 2018/5/16.
 */
public class App {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();

        new Thread(new Producer(resource)).start();

        new Thread(new Consumer(resource)).start();
    }
}
