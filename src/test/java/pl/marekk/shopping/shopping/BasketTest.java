package pl.marekk.shopping.shopping;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.marekk.shopping.shopping.Basket.basket;
import static pl.marekk.shopping.shopping.Item.item;
import static pl.marekk.shopping.shopping.product.domain.ProductName.APPLE;
import static pl.marekk.shopping.shopping.product.domain.ProductName.BANANA;
import static pl.marekk.shopping.shopping.product.domain.ProductName.PAPAYA;

import java.util.List;
import org.junit.Test;

public class BasketTest {

  @Test
  public void returnZeroForEmptyBasket() {
    //when
    Receipt receipt = basket(newArrayList()).toReceipt();
    //then
    assertThat(receipt.toString()).isEqualTo("Total price: 0");
  }

  @Test
  public void shouldCalculate_440_forSampleBasket() {
    //given
    List<Item> items = newArrayList(
        item(APPLE, 6),
        item(BANANA, 6),
        item(PAPAYA, 3),
        item(APPLE, 4));
    //when
    Receipt receipt = basket(items).toReceipt();
    //then
    assertThat(receipt.toString())
        .contains("10xApple price: 250")
        .contains("6xBanana price: 90")
        .contains("3xPapaya price: 100 (regular price: 150)")
        .contains("Total price: 440.00");
  }

}