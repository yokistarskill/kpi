package kitchen.vegetable;

public class Onion extends AbstractVegetable {
  public Onion(double weight) {
    super("onion", weight);
  }

  @Override
  public double caloriesPer100g() {
    return 40.00;
  }
}
