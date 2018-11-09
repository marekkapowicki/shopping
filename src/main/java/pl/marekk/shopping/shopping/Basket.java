package pl.marekk.shopping.shopping;


import java.util.List;

import static java.util.stream.Collectors.*;
import static pl.marekk.shopping.shopping.Receipt.basketResult;

class Basket {
    private final List<Item> items;

    Basket(List<Item> items) {
        this.items = items;
    }

    Receipt toReceipt() {
        List<Item> groupedItems = groupItems(items);

        List<ItemReceipt> results = groupedItems.stream()
                .map(Item::toResult).collect(toList());
        return basketResult(results);
    }

    private List<Item> groupItems(final List<Item> items) {
        return items.stream()
                .collect(groupingBy(Item::getProductName, summingInt(Item::getQuantity)))
                .entrySet()
                .stream()
                .map(e -> new Item(e.getKey(), e.getValue())).collect(toList());
    }
}
