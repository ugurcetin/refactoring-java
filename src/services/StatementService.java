package services;

import enums.MovieType;
import models.Customer;
import models.Movie;
import models.MovieRental;

import java.util.HashMap;
import java.util.Map;

public class StatementService {
    private Map<String, Movie> movies;
    private RentalService rentalService;

    public StatementService(RentalService rentalService) {
        this.rentalService = rentalService;

        movies = new HashMap<>();
        movies.put("F001", new Movie("You've Got Mail", MovieType.REGULAR));
        movies.put("F002", new Movie("Matrix", MovieType.REGULAR));
        movies.put("F003", new Movie("Cars", MovieType.CHILDRENS));
        movies.put("F004", new Movie("Fast & Furious X", MovieType.NEW_RELEASE));
    }

    public String generateStatement(Customer customer) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

        for (MovieRental rental : customer.getRentals()) {
            Movie movie = movies.get(rental.getMovieId());

            double thisAmount = rentalService.calculateRentalAmount(movie.getType(), rental.getDays());

            frequentEnterPoints += rentalService.calculateFrequentPoints(movie.getType(), rental.getDays());

            result.append("\t").append(movie.getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentEnterPoints).append(" frequent points\n");

        return result.toString();
    }
}

