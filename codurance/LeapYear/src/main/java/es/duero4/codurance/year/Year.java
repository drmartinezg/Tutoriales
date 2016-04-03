package es.duero4.codurance.year;

public class Year {
    private final int year;

    public Year(int year) {
        this.year = year;
    }
    
    public Boolean leapYear() {
        return divisibleBy(4) && !(divisibleBy(100) && notDivisibleBy(400));
    }

    private boolean notDivisibleBy(final int number) {
        return year % number != 0;
    }

    private boolean divisibleBy(final int number) {
        return year % number == 0;
    }
}
