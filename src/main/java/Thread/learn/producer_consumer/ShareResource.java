package Thread.learn.producer_consumer;

/**
 * Created by wangnan01 on 2018/5/16.
 */
public class ShareResource {
    private String name;
    private String gender;
    private boolean isEmpty = true;

    synchronized public void push(String name, String gender) {
        try {
            while (!isEmpty) {
                this.wait();
            }
            this.name = name;
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.gender = gender;
        isEmpty = false;
        this.notify();
    }

    synchronized public void popup() {
        try {
            while (isEmpty){
                this.wait();
            }
            System.out.println(name + "-" + gender);
            isEmpty = true;
            this.notify();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
