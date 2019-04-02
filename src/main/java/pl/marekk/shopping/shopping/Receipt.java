package pl.marekk.shopping.shopping;

import static pl.marekk.shopping.shopping.product.domain.pricing.Price.totalPrice;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import pl.marekk.shopping.shopping.product.domain.pricing.Price;

class Receipt {

  private final List<ItemReceipt> itemReceipts;
  private final Price calculatedPrice;

  private Receipt(List<ItemReceipt> itemReceipts, Price calculatedPrice) {
    this.itemReceipts = itemReceipts;
    this.calculatedPrice = calculatedPrice;
  }

  static Receipt basketResult(List<ItemReceipt> itemReceipts) {
    Price total = itemReceipts.stream()
        .map(ItemReceipt::getPrice)
        .reduce(totalPrice(BigDecimal.ZERO), Price::plus);
    return new Receipt(itemReceipts, total);
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
        .map(ItemReceipt::description).collect(Collectors.joining("\n")) + "\n";
  }
}
