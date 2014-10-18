package com.codekatas.checkout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstantPricingRuleTest {

    private ConstantPricingRule pricingRule;

    @Before
    public void setUp() throws Exception {
        pricingRule = new ConstantPricingRule(50);
    }

    @Test
    public void shouldCalculatePrice() throws Exception {
        assertEquals(0, pricingRule.calculatePrice(0), 0);
        assertEquals(50, pricingRule.calculatePrice(1), 0);
        assertEquals(100, pricingRule.calculatePrice(2), 0);
        assertEquals(150, pricingRule.calculatePrice(3), 0);
        assertEquals(200, pricingRule.calculatePrice(4), 0);
    }
}