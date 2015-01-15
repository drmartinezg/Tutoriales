package es.duero4.refactoring.gildedrosekata;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
    }

    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            Item current = items.get(i);
            String currentItemName = current.getName();
            boolean notBrie = !"Aged Brie".equals(currentItemName);
            boolean notBackstage = !"Backstage passes to a TAFKAL80ETC concert".equals(currentItemName);
            if (notBrie && notBackstage) {
                if (current.getQuality() > 0) {
                    if (!"Sulfuras, Hand of Ragnaros".equals(currentItemName)) {
                        current.setQuality(current.getQuality() - 1);
                    }
                }
            } else {
                if (current.getQuality() < 50) {
                    current.setQuality(current.getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(currentItemName)) {
                        if (current.getSellIn() < 11) {
                            if (current.getQuality() < 50) {
                                current.setQuality(current.getQuality() + 1);
                            }
                        }

                        if (current.getSellIn() < 6) {
                            if (current.getQuality() < 50) {
                                current.setQuality(current.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(currentItemName)) {
                current.setSellIn(current.getSellIn() - 1);
            }

            if (current.getSellIn() < 0) {
                if (currentItemName != "Aged Brie") {
                    if (notBackstage) {
                        if (current.getQuality() > 0) {
                            if (!"Sulfuras, Hand of Ragnaros".equals(currentItemName)) {
                                current.setQuality(current.getQuality() - 1);
                            }
                        }
                    } else {
                        current.setQuality(current.getQuality() - current.getQuality());
                    }
                } else {
                    if (current.getQuality() < 50) {
                        current.setQuality(current.getQuality() + 1);
                    }
                }
            }
        }
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> newItems) {
        items = newItems;
    }

    public static void resetItems() {
        items = new ArrayList<Item>();
    }
}
