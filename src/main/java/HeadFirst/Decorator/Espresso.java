package HeadFirst.Decorator;

public class Espresso extends Beverage {
    public Espresso() {
        descriprion = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
