package HeadFirst.Decorator;

public class Decaf extends Beverage {
    public Decaf() {
        descriprion = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
