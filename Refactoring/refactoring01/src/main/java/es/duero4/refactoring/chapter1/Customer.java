package es.duero4.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramon
 */
public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double amount = 0;
            
            frequentRenterPoints += rental.getFrequentRenterPoints();

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

    private double getTotalCharge() {
        double total = 0;
        for (Rental rental : rentals) {
            total += rental.getCharge();
        }
        return total;
    }

}
