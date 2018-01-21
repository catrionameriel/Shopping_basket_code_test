import basket.Basket;
import basket.Brie;
import basket.Milk;
import discount.TenPercentOffDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TenPercentOffTest {

    private TenPercentOffDiscount discount;
    private Basket basket;
    private Brie brie;
    private Milk milk;

    @Before
    public void before() {
        brie = new Brie("Brie", 10.00);
        milk = new Milk("Milk", 1.00);
        basket = new Basket();
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        discount = new TenPercentOffDiscount();
    }

    @Test
    public void canApplyDiscount() {
        basket.addItemsToBasket(brie);
        assertEquals(2.10, discount.applyDiscount(basket.getItems()), 0.01);
    }

    @Test
    public void cannotApplyDiscountWhenTotalIsNotTwenty() {
        assertEquals(0, discount.applyDiscount(basket.getItems()), 0.01);
    }
}
