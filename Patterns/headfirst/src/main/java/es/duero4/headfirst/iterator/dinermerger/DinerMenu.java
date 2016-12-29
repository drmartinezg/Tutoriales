package es.duero4.headfirst.iterator.dinermerger;

/**
 *
 * @author ramon
 */
public class DinerMenu {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        
        addItem("Vegetarian BLT", 
                "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", 
                "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", 
                "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog", 
                "A hot dog, with saurkraut, relish, onions, topped whit cheese", false, 3.05);
        addItem("Steamed Veggies and Brwon Rice", 
                "Streamed vegetables over brown rice", true, 3.99);
        addItem("Pasta", 
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89);
        
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

// We're not going to need this method anymore and in fact, we don't want it
// because it exposes out internal implementation!
    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
    
}
