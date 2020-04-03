package kitchen.vegetable;

public abstract class AbstractVegetable {
  private String name;
  private double weight;

  protected AbstractVegetable(String name, double weight) {
    this.name = name;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public double getWeight() {
    return weight;
  }

  public double calories() {
    return weight / 100.0 * caloriesPer100g();
  }

  public abstract double caloriesPer100g();

  @Override
  public String toString() {
    return String.format("%s, weight: %.2f, %.2f calories per 100g",
      name, weight, caloriesPer100g());
  }
}
