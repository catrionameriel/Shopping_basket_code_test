import basket.Basket;
import basket.Brie;
import basket.Milk;
import discount.BogofDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BogofTest {

    private BogofDiscount bogof;
    private Basket basket;
    private Brie brie;
    private Milk milk;

    @Before
    public void before() {
        brie = new Brie("Brie", 3.00);
        milk = new Milk("Milk", 1.00);
        basket = new Basket();
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(brie);
        bogof = new BogofDiscount(brie);
    }

    @Test
    public void canGetItemsToDiscount() {
        assertNotNull(bogof.createListToApplyDiscount(basket.getItems()));
        assertEquals(2, basket.countItemsInBasket());
        assertEquals(2, basket.getItems().size());
        assertEquals(2, bogof.createListToApplyDiscount(basket.getItems()).size());
    }

    @Test
    public void canApplyDiscountForTwoItems() {
        assertEquals(3.00, bogof.applyDiscount(basket.getItems()), 0.01);
    }

    @Test
    public void canApplyDiscountForFourItems() {
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(brie);
        assertEquals(6.00, bogof.applyDiscount(basket.getItems()), 0.01);
    }


    @Test
    public void canApplyDiscountWithOneItemIsNotRight() {
        basket.addItemsToBasket(milk);
        assertEquals(3.00, bogof.applyDiscount(basket.getItems()), 0.01);
    }

    @Test
    public void canApplyDiscountForThreeItems() {
        basket.addItemsToBasket(brie);
        assertEquals(6.00, bogof.applyDiscount(basket.getItems()), 0.01);
    }
}
