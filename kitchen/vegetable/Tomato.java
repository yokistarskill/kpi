package kitchen.vegetable;

public class Tomato extends AbstractVegetable {
  public Tomato(double weight) {
    super("tomato", weight);
  }

  @Override
  public double caloriesPer100g() {
    return 17.69;
  }
}
