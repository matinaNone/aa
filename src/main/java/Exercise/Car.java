package Exercise;

/**
 * Created by wangnan01 on 2017/11/9.
 */
public class Car extends Vehicle {

     private void run(){
        System.out.println("Car");
    }


    public static void main(String[] args) {
        new Car().run();
    }
}
