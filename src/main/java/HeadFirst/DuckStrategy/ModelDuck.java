package HeadFirst.DuckStrategy;

import HeadFirst.DuckStrategy.Behavior.impl.FlyNoWay;
import HeadFirst.DuckStrategy.Behavior.impl.MuteQuack;

/**
 * Created by wangnan01 on 2019/8/16.
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck~");
    }
}
