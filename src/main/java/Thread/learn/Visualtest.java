package Thread.learn;

/**
 * Created by wangnan01 on 2019/8/22.
 */
public class Visualtest {
        private static long count = 0;
        private void add() {
            int idx = 0;
            while(idx++ < 100000) {
                count += 1;
            }
        }

        public static long calc() throws InterruptedException {
            final Visualtest test = new Visualtest();
            // 创建两个线程，执行 add() 操作
            Thread th1 = new Thread(test::add);
            Thread th2 = new Thread(test::add);
            // 启动两个线程
            th1.start();
            th2.start();
            // 等待两个线程执行结束
            th1.join();
            th2.join();
            return count;
        }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(calc());
    }

}
