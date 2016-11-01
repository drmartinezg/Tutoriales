package es.duero4.headfirst.facade.hometheater;

/**
 *
 * @author ramon
 */
public class Screen {
    private final String description;

    public Screen(String description) {
        this.description = description;
    }

    public void up() {
        System.out.println(description + " going up");
    }
    
    public void down() {
        System.out.println(description + " going down");
    }

    @Override
    public String toString() {
        return description;
    }

}
