package pl.marekk.shopping.shopping;

import pl.marekk.shopping.shopping.product.domain.pricing.Price;

class ItemReceipt {
    private final Item item;
    private final Price price;

    ItemReceipt(Item item, Price price) {
        this.item = item;
        this.price = price;
    }

    Price getPrice() {
        return price;
    }

    String description() {
        return item.description() + " " + price.description();
    }
}
