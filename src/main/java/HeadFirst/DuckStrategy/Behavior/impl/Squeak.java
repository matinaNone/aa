package HeadFirst.DuckStrategy.Behavior.impl;

import HeadFirst.DuckStrategy.Behavior.QuackBehavior;

/**
 * Created by wangnan01 on 2019/8/16.
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak~");
    }
}
