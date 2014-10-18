package com.codekatas.checkout;

import java.util.HashMap;
import java.util.Map;

/**
 * Price calculator for items.
 */
public class PriceCalculator {

    private Map<String, PricingRule> pricingRules = new HashMap<>();

    public double calculateTotalItemsPrice(Map<String, Integer> items) {
        double totalPrice = 0;

        for (Map.Entry<String, Integer> itemEntry : items.entrySet()) {
            String item = itemEntry.getKey();
            if (pricingRules.containsKey(item)) {
                // calculate the total price for all items of this type
                totalPrice += calculateTotalItemPrice(item, itemEntry.getValue());
            } else {
                throw new IllegalStateException("no pricing rule found for item " + item);
            }
        }

        return totalPrice;
    }

    private double calculateTotalItemPrice(String item, int itemCount) {
        PricingRule pricingRule = pricingRules.get(item);

        return pricingRule.calculatePrice(itemCount);
    }

    public void registerPricingRule(String item, PricingRule pricingRule) {
        pricingRules.put(item, pricingRule);
    }
}
