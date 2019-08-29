package HeadFirst.Decorator;

public abstract class Beverage {
    String descriprion = "Unknown Beverrage";

    public String getDescription() {
        return descriprion;
    }

    public abstract double cost();
}
