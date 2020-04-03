package kitchen;

import java.util.*;

import kitchen.vegetable.*;

public class Salad {
  private List<AbstractVegetable> vegetables;

  public Salad() {
    this.vegetables = new ArrayList<>();
  }

  public void addVegetable(AbstractVegetable vegetable) {
    vegetables.add(vegetable);
  }

  public double calories() {
    double ret = 0.0;
    for (AbstractVegetable vegetable : vegetables) {
      ret += vegetable.calories();
    }
    return ret;
  }

  public List<AbstractVegetable> sortedByWeight() {
    List<AbstractVegetable> ret = new ArrayList<>(vegetables);
    Collections.sort(ret, (a, b) -> Double.compare(a.getWeight(), b.getWeight()));
    return ret;
  }

  public List<AbstractVegetable> withCaloriesPer100gBetween(double min, double max) {
    List<AbstractVegetable> ret = new ArrayList<>();
    for (AbstractVegetable vegetable : vegetables) {
      if (vegetable.caloriesPer100g() >= min && vegetable.caloriesPer100g() <= max) {
        ret.add(vegetable);
      }
    }
    return ret;
  }

  public List<AbstractVegetable> getVegetables() {
    return vegetables;
  }
}
