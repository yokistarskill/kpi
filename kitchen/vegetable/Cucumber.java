package kitchen.vegetable;

public class Cucumber extends AbstractVegetable {
  public Cucumber(double weight) {
    super("cucumber", weight);
  }

  @Override
  public double caloriesPer100g() {
    return 15.54;
  }
}
