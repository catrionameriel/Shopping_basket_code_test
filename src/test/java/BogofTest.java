import basket.Basket;
import basket.Item;
import discount.BogofDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BogofTest {

    private BogofDiscount bogof;
    private Basket basket;
    private Basket basket2;
    private Item butter;
    private Item lettuce;
    private Item lettuce2;

    @Before
    public void before() {
        butter = new Item("Butter", 3.00);
        lettuce = new Item("Lettuce", 1.00);
        lettuce2 = new Item("Lettuce", 1.25);
        basket = new Basket();
        basket.addItemsToBasket(butter);
        basket.addItemsToBasket(butter);
        basket2 = new Basket();
        basket2.addItemsToBasket(lettuce);
        basket2.addItemsToBasket(lettuce2);
        bogof = new BogofDiscount(butter);
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
        basket.addItemsToBasket(butter);
        basket.addItemsToBasket(butter);
        assertEquals(6.00, bogof.applyDiscount(basket.getItems()), 0.01);
    }

    @Test
    public void canApplyDiscountForThreeItems() {
        basket.addItemsToBasket(butter);
        assertEquals(6.00, bogof.applyDiscount(basket.getItems()), 0.01);
    }
}
