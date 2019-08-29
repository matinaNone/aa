package Thread.learn;

/**
 * Created by wangnan01 on 2017/7/11.
 *
 */
public class PrimeThread extends Thread{
        long minPrime;

        PrimeThread(long minPrime) {
            this.minPrime = minPrime;
        }

        @Override
        public void run() {
            while (true) {
                minPrime++;
                boolean flag = true;
                for (int i = 2; i <= minPrime - 1; i++) {
                    if (minPrime % i == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("prime: " + minPrime);
                    break;
                }
            }
        }

        public static void main(String[] args) {
            PrimeThread pth = new PrimeThread(1568549);
            Thread p = new Thread(pth);
            p.start();
    }
}
