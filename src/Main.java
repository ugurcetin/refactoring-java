import models.Customer;
import models.MovieRental;
import services.RentalService;
import services.StatementService;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

    List<MovieRental> rentals = new ArrayList<>();
    rentals.add(new MovieRental("F001", 3));
    rentals.add(new MovieRental("F002", 1));

    Customer customer = new Customer("C. U. Stomer", rentals);
    StatementService statementService = new StatementService(new RentalService());
    String result = statementService.generateStatement(customer);

    if (!result.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + expected + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }

    System.out.println("Success");
  }
}
