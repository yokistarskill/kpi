import java.util.Scanner;
import java.util.stream.Collectors;

import kitchen.Salad;
import kitchen.vegetable.*;

class Main {
  public static void main(String[] args) {
    System.out.println("hello world");

    Scanner scanner = new Scanner(System.in);

    Salad salad = new Salad();

    while (true) {
      System.out.println("\noptions:");
      System.out.println("  1) create new salad");
      System.out.println("  2) add a vegetable");
      System.out.println("  3) get total calories");
      System.out.println("  4) sort vegetables by weight");
      System.out.println("  5) find vegetables by calories");
      System.out.println("  6) exit");
      System.out.println();

      System.out.print("i want to: ");
      int opt = Integer.parseInt(scanner.nextLine());

      if (opt == 6) {
        System.out.println("bye");
        break;
      }

      switch (opt) {
        case 1:
          {
            salad = new Salad();
            System.out.println("done");
          }
          break;
        case 2:
          {
            System.out.println("available vegetables: cucumber, onion, potato, tomato");
            System.out.print("enter a vegetable: ");
            String vegetableName = scanner.nextLine().toLowerCase();

            System.out.print("enter a weight (in grams): ");
            double weight = Double.parseDouble(scanner.nextLine());

            AbstractVegetable vegetable = null;
            switch (vegetableName) {
              case "cucumber":
                vegetable = new Cucumber(weight);
                break;
              case "onion":
                vegetable = new Onion(weight);
                break;
              case "potato":
                vegetable = new Potato(weight);
                break;
              case "tomato":
                vegetable = new Tomato(weight);
                break;
            }

            if (vegetable != null) {
              salad.addVegetable(vegetable);
              System.out.println("done");
            } else {
              System.out.println("invalid vegetable");
            }
          }
          break;
        case 3:
          {
            System.out.printf("total calories = %.2f%n", salad.calories());
          }
          break;
        case 4:
          {
            System.out.println("by weight:");
            System.out.println(salad.sortedByWeight()
              .stream()
              .map(Object::toString)
              .collect(Collectors.joining("\n")));
          }
          break;
        case 5:
          {
            System.out.print("enter min calories (per 100g): ");
            double min = Double.parseDouble(scanner.nextLine());
            System.out.print("enter max calories (per 100g): ");
            double max = Double.parseDouble(scanner.nextLine());
            System.out.println("\nresult:");
            System.out.println(salad.withCaloriesPer100gBetween(min, max)
              .stream()
              .map(Object::toString)
              .collect(Collectors.joining("\n")));
          }
          break;
      }
    }
  }
}
