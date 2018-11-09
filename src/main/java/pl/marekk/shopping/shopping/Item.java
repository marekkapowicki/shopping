package pl.marekk.shopping.shopping;

import pl.marekk.shopping.shopping.product.domain.ProductName;
import pl.marekk.shopping.shopping.product.domain.Products;

class Item {
    private final ProductName productName;
    private final int quantity;

    Item(ProductName productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    ProductName getProductName() {
        return productName;
    }

    int getQuantity() {
        return quantity;
    }

    ItemReceipt toResult() {
        return new ItemReceipt(this, Products.findFor(productName).calculatePrice(quantity));
    }

    String description() {
        return quantity + "x" + productName;
    }
}
