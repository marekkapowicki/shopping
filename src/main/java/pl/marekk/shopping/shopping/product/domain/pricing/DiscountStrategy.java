package pl.marekk.shopping.shopping.product.domain.pricing;

import static java.math.BigDecimal.valueOf;
import static pl.marekk.shopping.shopping.product.domain.pricing.Price.discountPrice;

import java.math.BigDecimal;

class DiscountStrategy implements PricingStrategy {

  private final BigDecimal pricePerUnit;
  private final DiscountRule discountRule;


  DiscountStrategy(BigDecimal pricePerUnit, DiscountRule discountRule) {
    this.pricePerUnit = pricePerUnit;
    this.discountRule = discountRule;
  }

  @Override
  public Price calculatePrice(int unitNumber) {
    return discountPrice(pricePerUnit.multiply(valueOf(unitNumber)),
        discountRule.calculate(pricePerUnit, unitNumber));
  }
}
