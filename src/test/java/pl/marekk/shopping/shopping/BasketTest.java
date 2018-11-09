package pl.marekk.shopping.shopping;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static pl.marekk.shopping.shopping.product.domain.ProductName.*;

public class BasketTest {

    @Test
    public void shouldWork() {
        //given
        List<Item> items = Lists.newArrayList(new Item(APPLE, 6), new Item(BANANA, 6), new Item(PAPAYA, 5),
                new Item(APPLE, 4));
        //when
        Receipt receipt = new Basket(items).toReceipt();
        //then
        System.out.print(receipt);
    }
}