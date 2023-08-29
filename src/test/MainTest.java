package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import enums.MovieType;
import models.Customer;
import models.Movie;
import models.MovieRental;
import services.RentalService;
import services.StatementService;

public class MainTest {

    private RentalService rentalService;
    private StatementService statementService;

    @Before
    public void setup() {
        rentalService = new RentalService();
        statementService = new StatementService(rentalService);
    }

    @Test
    public void testGenerateStatement() {
        String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

        List<MovieRental> rentals = new ArrayList<>();
        rentals.add(new MovieRental("F001", 3));
        rentals.add(new MovieRental("F002", 1));

        Customer customer = new Customer("C. U. Stomer", rentals);

        String result = statementService.generateStatement(customer);

        assertEquals(expected, result);
    }

    @Test
    public void testCalculateRentalAmount() {
        // You can add more test cases to cover different movie types and rental days
        double amount = rentalService.calculateRentalAmount(MovieType.REGULAR, 3);
        assertEquals(3.5, amount, 0.01); // Using delta to account for floating-point precision

        amount = rentalService.calculateRentalAmount(MovieType.NEW_RELEASE, 2);
        assertEquals(6.0, amount, 0.01);
    }

    @Test
    public void testCalculateFrequentPoints() {
        // You can add more test cases to cover different movie types and rental days
        int points = rentalService.calculateFrequentPoints(MovieType.REGULAR, 3);
        assertEquals(1, points);

        points = rentalService.calculateFrequentPoints(MovieType.NEW_RELEASE, 2);
        assertEquals(2, points);
    }
}

