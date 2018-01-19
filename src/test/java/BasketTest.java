import basket.Basket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    private Basket basket;

    @Before
    public void before() {
       basket = new Basket();
    }

    @Test
    public void itemsInBasketStartsAtZero() {
        assertEquals(0, basket.countItemsInBasket());
    }
}
