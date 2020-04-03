package kitchen.vegetable;

public class Potato extends AbstractVegetable {
  public Potato(double weight) {
    super("potato", weight);
  }

  @Override
  public double caloriesPer100g() {
    return 77.00;
  }
}
