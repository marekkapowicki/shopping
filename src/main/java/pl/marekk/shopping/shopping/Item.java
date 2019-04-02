package pl.marekk.shopping.shopping;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import pl.marekk.shopping.shopping.product.domain.ProductName;
import pl.marekk.shopping.shopping.product.domain.Products;

class Item {

  private final ProductName productName;
  private final int quantity;

  private Item(ProductName productName, int quantity) {
    this.productName = productName;
    this.quantity = quantity;
  }

  static Item item(ProductName productName, int quantity) {
    return new Item(productName, quantity);
  }

  static List<Item> groupItems(final List<Item> items) {
    return items.stream()
        .collect(groupingBy(Item::getProductName, summingInt(Item::getQuantity)))
        .entrySet()
        .stream()
        .map(e -> item(e.getKey(), e.getValue()))
        .sorted(Item.comparator())
        .collect(toList());
  }

  private static Comparator<Item> comparator() {
    return Comparator.comparing(Item::getProductName);
  }

  ItemReceipt toResult() {
    return new ItemReceipt(this, Products.findFor(productName).calculatePrice(quantity));
  }

  String description() {
    return quantity + "x" + productName;
  }

  private ProductName getProductName() {
    return productName;
  }

  private int getQuantity() {
    return quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return productName == item.productName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(productName);
  }
}
