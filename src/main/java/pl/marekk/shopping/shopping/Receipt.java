package pl.marekk.shopping.shopping;

import pl.marekk.shopping.shopping.product.domain.pricing.Price;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static pl.marekk.shopping.shopping.product.domain.pricing.Price.totalPrice;

class Receipt {

    private final List<ItemReceipt> itemReceipts;
    private final Price calculatedPrice;

    static Receipt basketResult(List<ItemReceipt> itemReceipts) {
        Price total = itemReceipts.stream()
                .map(ItemReceipt::getPrice)
                .reduce(totalPrice(BigDecimal.ZERO), Price::plus);
        return new Receipt(itemReceipts, total);
    }

    private Receipt(List<ItemReceipt> itemReceipts, Price calculatedPrice) {
        this.itemReceipts = itemReceipts;
        this.calculatedPrice = calculatedPrice;
    }

    @Override
    public String toString() {
        return printItems() + calculatedPrice.description();
    }

    private String printItems() {
        if (itemReceipts == null || itemReceipts.isEmpty()) {
            return "";
        }
        return itemReceipts.stream()
                .map(ItemReceipt::description).collect(Collectors.joining("\n"))+ "\n";
    }
}
