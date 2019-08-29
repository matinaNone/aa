package HeadFirst.DuckStrategy.Behavior.impl;

import HeadFirst.DuckStrategy.Behavior.FlyBehavior;

/**
 * Created by wangnan01 on 2019/8/16.
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying~");
    }
}
