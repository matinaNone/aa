package HeadFirst.Decorator;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        descriprion = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
