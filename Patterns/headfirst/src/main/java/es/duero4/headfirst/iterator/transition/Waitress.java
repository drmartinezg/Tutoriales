package es.duero4.headfirst.iterator.transition;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ramon
 */
public class Waitress {
    ArrayList menus;

    public Waitress(ArrayList menus) {
        this.menus = menus;
    }
    
    public void printMenu() {
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu)menuIterator.next();
            printMenu(menu.createIterator());
            
        }
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {            
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}
