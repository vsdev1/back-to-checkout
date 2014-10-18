package com.codekatas.checkout;

/**
 * Pricing rule that calculates a discount price for every n-th item.
 */
public class GetOneWithDiscountPricingRule implements PricingRule {

    private double basePrice;
    private double discountPrice;
    private int discountInterval;

    /**
     * Constructor.
     *
     * @param basePrice base price
     * @param discountPrice discount price
     * @param discountInterval every discountInterval's item gets the discount price
     */
    public GetOneWithDiscountPricingRule(double basePrice, double discountPrice, int discountInterval) {
        if (discountPrice > basePrice) {
            throw new IllegalArgumentException("discount price " + discountPrice
                    + " must not be greater than the base price " + basePrice);
        }

        this.basePrice = basePrice;
        this.discountPrice = discountPrice;
        this.discountInterval = discountInterval;
    }

    @Override
    public double calculatePrice(int itemCount) {
        int discountItemCount = itemCount / discountInterval;
        return discountItemCount * discountPrice +  (itemCount - discountItemCount) * basePrice;
    }
}
