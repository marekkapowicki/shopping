package pl.marekk.shopping.shopping.product.domain.pricing;

import java.math.BigDecimal;

class TotalPrice implements Price {
    private final BigDecimal totalPrice;

    TotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public BigDecimal value() {
        return format(totalPrice);
    }

    @Override
    public String description() {
        return "Total price: " + totalPrice;
    }
}
