package es.duero4.refactoring.gildedrosekata;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    private static final String AGED__BRIE = "Aged Brie";
    private static final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final int MAXIMUM_QUALITY = 50;
    private static final int MINIMUM_QUALITY = 0;
    private static final int QUALITY_GRANULARITY = 1;
    private static final int DOUBLE_INCREMENT_THRESHOLD = 10;
    private static final int TRIPLE_INCREMENT_THRESHOLD = 5;
    private static final int SELLIN_GRANULARITY = 1;

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
            boolean itIsAPass = PASSES.equals(currentItemName);
            boolean notPass = !itIsAPass;
            boolean notSulfuras = !SULFURAS.equals(currentItemName);
            
            boolean norBrieNeitherPass = notBrie && notPass;
            boolean hasSomeQuality = current.getQuality() > MINIMUM_QUALITY;
            boolean maximumQualityNotReached = current.getQuality() < MAXIMUM_QUALITY;
            boolean itIsInDoubleIncrement = current.getSellIn() <= DOUBLE_INCREMENT_THRESHOLD;
            boolean itIsInTripleIncrement = current.getSellIn() <= TRIPLE_INCREMENT_THRESHOLD;
            
            if (norBrieNeitherPass) {
                if (hasSomeQuality) {
                    if (notSulfuras) {
                        decreaseQuality(current);
                    }
                }
            } else {
                if (maximumQualityNotReached) {
                    increaseQuality(current);

                    if (itIsAPass) {
                        if (itIsInDoubleIncrement) {
                            if (maximumQualityNotReached) {
                                increaseQuality(current);
                            }
                        }

                        if (itIsInTripleIncrement) {
                            if (maximumQualityNotReached) {
                                increaseQuality(current);
                            }
                        }
                    }
                }
            }

            if (notSulfuras) {
                decreaseSellIn(current);
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
        current.setQuality(current.getQuality() - QUALITY_GRANULARITY);
    }

    private static void increaseQuality(Item current) {
        current.setQuality(current.getQuality() + QUALITY_GRANULARITY);
    }
    
    private static void decreaseSellIn(Item current) {
        current.setSellIn(current.getSellIn() - SELLIN_GRANULARITY);
    }
}
