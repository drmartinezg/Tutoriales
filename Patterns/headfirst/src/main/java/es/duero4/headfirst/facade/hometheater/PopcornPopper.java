package es.duero4.headfirst.facade.hometheater;

/**
 *
 * @author ramon
 */
public class PopcornPopper {
    private final String description;

    public PopcornPopper(String description) {
        this.description = description;
    }

    void on() {
        System.out.println(description + " on");
    }

    void off() {
        System.out.println(description + " off");
    }
    
    void pop() {
        System.out.println(description + " popping popcorn!");
    }

    @Override
    public String toString() {
        return description;
    }

    
}
