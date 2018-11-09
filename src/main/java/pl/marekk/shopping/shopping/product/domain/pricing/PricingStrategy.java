package pl.marekk.shopping.shopping.product.domain.pricing;

import java.math.BigDecimal;

public interface PricingStrategy {
    Price calculatePrice(int unitNumber);

    static PricingStrategy standard(BigDecimal pricePerUnit) {
        return new StandardStrategy((pricePerUnit));
    }

    static PricingStrategy multiPackDiscount(BigDecimal pricePerUnit, int payForNumber, int takeNumber) {
        return new DiscountStrategy(pricePerUnit, new DiscountRule(payForNumber, takeNumber));
    }
}
