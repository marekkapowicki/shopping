package pl.marekk.shopping.shopping.product.domain.pricing;

import java.math.BigDecimal;

public class StandardStrategy implements PricingStrategy {
    private final BigDecimal pricePerUnit;

    StandardStrategy(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Price calculatePrice(int unitNumber) {
        return Price.standardPrice(pricePerUnit.multiply(BigDecimal.valueOf(unitNumber)));
    }
}
