package Thread.learn.method;

/**
 * Created by wangnan01 on 2018/5/23.
 */
class Join extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("join: " + i);
        }
    }
}

public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin...");
        Join join = new Join();
        for (int i = 0; i < 100; i++) {
            System.out.println("main: " + i);
            if (i == 10){
                System.out.println("=====================");
                join.start();
            }
            if (i == 20){
                System.out.println("999999999999999999");
                join.join();
            }

        }
        System.out.println("end.......");
    }
}
