package HeadFirst.Decorator;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        descriprion = "Dark Roast";
    }

    @Override
    public double cost() {
        return .99;
    }
}
