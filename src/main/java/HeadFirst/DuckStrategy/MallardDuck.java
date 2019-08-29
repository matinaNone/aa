package HeadFirst.DuckStrategy;

import HeadFirst.DuckStrategy.Behavior.impl.FlyWithWings;
import HeadFirst.DuckStrategy.Behavior.impl.Quack;

/**
 * Created by wangnan01 on 2019/8/16.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }



    @Override
    public void display() {
        System.out.println("I'm mallard duck");
    }
}
