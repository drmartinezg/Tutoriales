package es.duero4.codurance.year;

public class Year {
    private final int year;

    public Year(int year) {
        this.year = year;
    }
    
    public Boolean leapYear() {
        return year % 4 == 0;
    }
}
