package pl.marekk.shopping.shopping.product.domain.pricing;

import java.math.BigDecimal;

import static pl.marekk.shopping.shopping.product.domain.pricing.Price.discountPrice;

class DiscountStrategy implements PricingStrategy {
    private final BigDecimal pricePerUnit;
    private final DiscountRule discountRule;


    DiscountStrategy(BigDecimal pricePerUnit, DiscountRule discountRule) {
        this.pricePerUnit = pricePerUnit;
        this.discountRule = discountRule;
    }

    @Override
    public Price calculatePrice(int unitNumber) {
        return discountPrice(pricePerUnit, BigDecimal.TEN);
    }
}
