package services;

import enums.MovieType;

public class RentalService {
    public double calculateRentalAmount(MovieType type, int days) {
        double amount = 0;

        switch (type) {
            case REGULAR:
                amount = 2;
                if (days > 2) {
                    amount += (days - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                amount = days * 3;
                break;
            case CHILDRENS:
                amount = 1.5;
                if (days > 3) {
                    amount += (days - 3) * 1.5;
                }
                break;
        }

        return amount;
    }

    public int calculateFrequentPoints(MovieType type, int days) {
        if (type == MovieType.NEW_RELEASE && days > 1) {
            return 2;
        }
        return 1;
    }
}

