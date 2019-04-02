package pl.marekk.shopping.shopping.product.domain.pricing;

import java.math.BigDecimal;

class DiscountRule {

  private final int payForUnitNumber;
  private final int takeUnitNumber;

  DiscountRule(int payForUnitNumber, int takeUnitNumber) {
    this.payForUnitNumber = payForUnitNumber;
    this.takeUnitNumber = takeUnitNumber;
  }

  BigDecimal calculate(BigDecimal price, int quantity) {
    int promotionQuantity = quantity / takeUnitNumber;
    int standardPriceQuantity = quantity % takeUnitNumber;

    return price
        .multiply(BigDecimal.valueOf(promotionQuantity * payForUnitNumber + standardPriceQuantity));
  }
}
