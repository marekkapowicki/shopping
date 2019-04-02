package pl.marekk.shopping.shopping.product.domain.pricing;

import java.math.BigDecimal;

class StandardPrice implements Price {

  private final BigDecimal price;

  StandardPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal value() {
    return format(price);
  }

  public String description() {
    return "price: " + price;
  }
}
