package pl.marekk.shopping.shopping.product.domain;

import com.google.common.collect.ImmutableMap;
import pl.marekk.shopping.shopping.product.domain.pricing.PricingStrategy;

import java.util.Map;

import static java.math.BigDecimal.valueOf;
import static java.util.Optional.ofNullable;
import static pl.marekk.shopping.shopping.product.domain.ProductName.*;
import static pl.marekk.shopping.shopping.product.domain.pricing.PricingStrategy.standard;

public class Products {
    private static final Map<ProductName, PricingStrategy> products =
            new ImmutableMap.Builder<ProductName, PricingStrategy>()
                    .put(APPLE, standard(valueOf(25L)))
                    .put(ORANGE, standard(valueOf(30L)))
                    .put(BANANA, standard(valueOf(15L)))
                    .put(PAPAYA, PricingStrategy.multiPackDiscount(valueOf(50L), 2, 3))
                    .build();

    public static PricingStrategy findFor(ProductName productName) {
        return ofNullable(products.get(productName))
                .orElseThrow(() -> new IllegalStateException("no price for: " + productName));
    }

}
