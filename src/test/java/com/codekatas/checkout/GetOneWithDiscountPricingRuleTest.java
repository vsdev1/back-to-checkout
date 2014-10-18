package com.codekatas.checkout;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetOneWithDiscountPricingRuleTest {

    private GetOneWithDiscountPricingRule pricingRule;

    @Test
    public void shouldCalculatePrice() throws Exception {
        pricingRule = new GetOneWithDiscountPricingRule(50, 30, 3);

        assertEquals(0, pricingRule.calculatePrice(0), 0);
        assertEquals(50, pricingRule.calculatePrice(1), 0);
        assertEquals(100, pricingRule.calculatePrice(2), 0);
        assertEquals(130, pricingRule.calculatePrice(3), 0);
        assertEquals(180, pricingRule.calculatePrice(4), 0);
        assertEquals(230, pricingRule.calculatePrice(5), 0);
        assertEquals(260, pricingRule.calculatePrice(6), 0);
        assertEquals(310, pricingRule.calculatePrice(7), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionBecauseDiscountPriceIsTooHigh() throws Exception {
        pricingRule = new GetOneWithDiscountPricingRule(50, 60, 3);

        pricingRule.calculatePrice(10);
    }

}