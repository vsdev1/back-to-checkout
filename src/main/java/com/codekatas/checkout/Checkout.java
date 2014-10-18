package com.codekatas.checkout;

import java.util.HashMap;
import java.util.Map;

/**
 * Checkout that scans items and calculates the total price.
 */
public class Checkout {

    private PriceCalculator priceCalculator;
    private Map<String, Integer> items = new HashMap<>();

    public Checkout(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    public void scan(String item) {
        if (!items.containsKey(item)) {
            items.put(item, 0);
        }

        items.put(item, items.get(item) + 1);
    }

    public double calculateTotalItemsPrice() {
        return priceCalculator.calculateTotalItemsPrice(items);
    }

    public void clearAllItems() {
        items.clear();
    }

    public int getScannedItemCount(String item) {
        Integer itemCount = items.get(item);

        return itemCount != null ? itemCount : 0;
    }
}
