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
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentPoints()) + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        String result = "<h1>Rental Record for <b>" + getName() + "</b></h1>\n";
        for (Rental rental : rentals) {
            result += "<p>" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "</p>\n";
        }
        result += "<p>Amount owed is <b>" + String.valueOf(getTotalCharge()) + "</b></p>\n";
        result += "<p>You earned <b>" + String.valueOf(getTotalFrequentPoints()) + "</b> frequent renter points</p>";
        return result;
    }
    
    private int getTotalFrequentPoints() {
        int total = 0;
        for (Rental rental : rentals) {
            total += rental.getFrequentRenterPoints();
        }
        return total;
    }

    private double getTotalCharge() {
        double total = 0;
        for (Rental rental : rentals) {
            total += rental.getCharge();
        }
        return total;
    }

}
