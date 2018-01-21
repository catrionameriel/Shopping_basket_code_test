import basket.Basket;
import basket.Brie;
import discount.LoyaltyCardDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoyaltyCardTest {

    private LoyaltyCardDiscount discount;
    private Basket basket;
    private Brie brie;

    @Before
    public void before() {
        discount = new LoyaltyCardDiscount();
        brie = new Brie("Brie", 7.00);
        basket = new Basket();
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(brie);
    }

    @Test
    public void canGetDiscount() {
        assertEquals(0.28, discount.applyDiscount(basket.getItems()), 0.01);
    }
}
