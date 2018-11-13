package pl.marekk.shopping.shopping;

import pl.marekk.shopping.shopping.product.domain.ProductName;
import pl.marekk.shopping.shopping.product.domain.Products;

import java.util.Comparator;
import java.util.Objects;

class Item {
    private final ProductName productName;
    private final int quantity;

    static Item item(ProductName productName, int quantity){
        return new Item(productName, quantity);
    }
    private Item(ProductName productName, int quantity) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return productName == item.productName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    static Comparator<Item> comparator() {
        return Comparator.comparing(Item::getProductName);
    }
}
