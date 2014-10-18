package com.codekatas.checkout;

/**
 * Pricing rule.
 */
public interface PricingRule {

    double calculatePrice(int itemCount);
}
