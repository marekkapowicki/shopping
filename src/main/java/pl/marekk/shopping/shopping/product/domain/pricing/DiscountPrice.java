package pl.marekk.shopping.shopping.product.domain.pricing;

import java.math.BigDecimal;

class DiscountPrice implements Price {
    private final BigDecimal normalPrice;
    private final BigDecimal currentPrice;

    DiscountPrice(BigDecimal normalPrice, BigDecimal currentPrice) {
        this.normalPrice = normalPrice;
        this.currentPrice = currentPrice;
    }

    @Override
    public BigDecimal value() {
        return format(currentPrice);
    }

    @Override
    public String description() {
        return "price: " + currentPrice + " (regular price: " + normalPrice + ")";
    }
}
