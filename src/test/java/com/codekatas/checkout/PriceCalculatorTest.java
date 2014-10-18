package com.codekatas.checkout;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PriceCalculatorTest {

    private PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    public void shouldCalculateTotalItemsPrice() throws Exception {
        Map<String, Integer> items = new HashMap();
        items.put("A", 3);
        priceCalculator.registerPricingRule("A", new ConstantPricingRule(50));
        priceCalculator.registerPricingRule("B", new ConstantPricingRule(30));

        assertEquals(150, priceCalculator.calculateTotalItemsPrice(items), 0);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotCalculateTotalItemsPriceDueToMissingPricingRule() throws Exception {
        Map<String, Integer> items = new HashMap();
        items.put("A", 3);

        priceCalculator.calculateTotalItemsPrice(items);
    }
}