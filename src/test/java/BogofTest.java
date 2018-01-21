import basket.Basket;
import basket.Item;
import discount.BogofDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BogofTest {

    private BogofDiscount bogof;
    private Basket basket;
    private Basket basket2;
    private Item butter;
    private Item lettuce;
    private Item lettuce2;

    @Before
    public void before() {
        bogof = new BogofDiscount(butter);
        butter = new Item("Butter", 3.00);
        lettuce = new Item("Lettuce", 1.00);
        lettuce2 = new Item("Lettuce", 1.25);
        basket = new Basket();
        basket.addItemsToBasket(butter);
        basket.addItemsToBasket(butter);
        basket2 = new Basket();
        basket2.addItemsToBasket(lettuce);
        basket2.addItemsToBasket(lettuce2);
    }

    @Test
    public void canApplyDiscount() {
        assertEquals(3.00, bogof.applyDiscount(basket.getItems()), 0.01);
    }
}
