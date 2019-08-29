package HeadFirst.DuckStrategy.Behavior.impl;

import HeadFirst.DuckStrategy.Behavior.FlyBehavior;

/**
 * Created by wangnan01 on 2019/8/16.
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly~");
    }
}
