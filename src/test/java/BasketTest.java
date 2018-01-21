import basket.Basket;
import basket.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    private Basket basket;
    private Item brie;
    private Item milk;

    @Before
    public void before() {
       basket = new Basket();
       brie = new Item("Brie", 7.25);
       milk = new Item("Milk", 0.80);
    }

    @Test
    public void itemsInBasketStartsAtZero() {
        assertEquals(0, basket.countItemsInBasket());
    }

    @Test
    public void canAddToBasket() {
        basket.addItemsToBasket(brie);
        assertEquals(1, basket.countItemsInBasket());
    }

    @Test
    public void canAddMoreThanOneItemToBasket() {
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        assertEquals(2, basket.countItemsInBasket());
    }

    @Test
    public void canTakeItemOutOfBasket() {
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        basket.deleteItemFromBasket(brie);
        assertEquals(1, basket.countItemsInBasket());
    }
}
