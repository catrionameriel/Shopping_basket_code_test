import basket.Basket;
import basket.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void canEmptyBasket() {
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        basket.emptyBasket();
        assertEquals(0, basket.countItemsInBasket());
    }

    @Test
    public void totalStartsAtZero() {
        assertEquals(0, basket.getTotal(), 0.01);
    }

    @Test
    public void totalCanBeCalculatedFromItems() {
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        assertEquals(8.05, basket.getTotal(), 0.01);
    }

    @Test
    public void canGetItems() {
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        assertNotNull(basket.getItems());
    }
}
