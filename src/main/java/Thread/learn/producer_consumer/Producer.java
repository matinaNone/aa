package Thread.learn.producer_consumer;

/**
 * Created by wangnan01 on 2018/5/16.
 */
public class Producer implements Runnable{

    private ShareResource resource = null;

    public Producer(ShareResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                resource.push("po","male");
            }else {
                resource.push("pn", "female");
            }
        }
    }
}
