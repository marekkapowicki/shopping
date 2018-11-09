package pl.marekk.shopping.shopping.product.domain.pricing;

import java.math.BigDecimal;

public interface Price {
    BigDecimal value();

    String description();

    default Price plus(Price price) {
        BigDecimal total = value().add(price.value());
        return new TotalPrice(total);
    }

    static Price standardPrice(BigDecimal price) {
        return new StandardPrice(price);
    }

    static Price discountPrice(BigDecimal normalPrice, BigDecimal currentPrice) {
        return new DiscountPrice(normalPrice, currentPrice);
    }

    default BigDecimal format(BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_UP);
    }
}
