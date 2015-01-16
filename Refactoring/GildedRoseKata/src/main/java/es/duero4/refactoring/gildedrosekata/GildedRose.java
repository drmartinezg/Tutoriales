package es.duero4.refactoring.gildedrosekata;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private static final String AGED__BRIE = "Aged Brie";
    private static final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int MINIMUM_QUALITY = 0;
    private static final int GRANULARITY = 1;

    private static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item(AGED__BRIE, 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item(SULFURAS, 0, 80));
        items.add(new Item(PASSES, 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
    }

    public static void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            Item current = items.get(i);
            String currentItemName = current.getName();
            
            boolean notBrie = !AGED__BRIE.equals(currentItemName);
            boolean notPass = !PASSES.equals(currentItemName);
            boolean notSulfuras = !SULFURAS.equals(currentItemName);
            
            boolean norBrieNeitherPass = notBrie && notPass;
            boolean hasSomeQuality = current.getQuality() > MINIMUM_QUALITY;
            
            if (norBrieNeitherPass) {
                if (hasSomeQuality) {
                    if (notSulfuras) {
                        decreaseQuality(current);
                    }
                }
            } else {
                if (current.getQuality() < 50) {
                    current.setQuality(current.getQuality() + 1);

                    if (PASSES.equals(currentItemName)) {
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

            if (notSulfuras) {
                current.setSellIn(current.getSellIn() - 1);
            }

            if (current.getSellIn() < 0) {
                if (currentItemName != AGED__BRIE) {
                    if (notPass) {
                        if (hasSomeQuality) {
                            if (notSulfuras) {
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
    
    private static void decreaseQuality(Item current) {
        current.setQuality(current.getQuality() - GRANULARITY);
    }
}
