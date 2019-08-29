package HeadFirst.DuckStrategy;

import HeadFirst.DuckStrategy.Behavior.impl.FlyWithRocket;

/**
 * Created by wangnan01 on 2019/8/16.
 */
public class DuckMain {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        mallard.display();

        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();
        model.setFlyBehavior(new FlyWithRocket());
        model.performFly();

        System.out.println(661+9.6*50+1.72*161-4.7*30);
    }
}
