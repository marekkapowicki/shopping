package pl.marekk.shopping.shopping;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.stream.Collectors.toList;
import static pl.marekk.shopping.shopping.Item.groupItems;
import static pl.marekk.shopping.shopping.Receipt.basketResult;

import java.util.List;

class Basket {

  private final List<Item> items;

  private Basket(List<Item> items) {
    this.items = items;
  }

  static Basket basket(List<Item> items) {
    checkArgument(items != null, "basket can not be null");
    return new Basket(groupItems(items));
  }

  Receipt toReceipt() {
    List<ItemReceipt> results = items.stream()
        .map(Item::toResult).collect(toList());
    return basketResult(results);
  }


}
