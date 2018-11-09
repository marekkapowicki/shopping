package pl.marekk.shopping.shopping.product.domain.pricing;


import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

public interface Price {
    BigDecimal value();

    String description();

    default Price plus(Price price) {
        BigDecimal total = value().add(price.value());
        return new TotalPrice(total);
    }

    static Price standardPrice(BigDecimal price) {
        validatePositiveAmount(price);
        return new StandardPrice(price);
    }

    static Price totalPrice(BigDecimal price) {
        validatePositiveAmount(price);
        return new TotalPrice(price);
    }

    static Price discountPrice(BigDecimal normalPrice, BigDecimal currentPrice) {
        validatePositiveAmount(currentPrice);
        return new DiscountPrice(normalPrice, currentPrice);
    }

    default BigDecimal format(BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_UP);
    }

    static void validatePositiveAmount(BigDecimal price) {
        checkArgument(price.compareTo(BigDecimal.ZERO)  >= 0, "price must be positive");
    }

}
