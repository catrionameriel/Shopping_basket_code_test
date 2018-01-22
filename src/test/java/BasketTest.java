import basket.*;
import discount.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasketTest {

    private Basket basket;
    private Brie brie;
    private Item milk;
    private IDiscount bogof;
    private IDiscount tenPercentOff;
    private IDiscount loyaltyCard;

    @Before
    public void before() {
        basket = new Basket();
        brie = new Brie("Brie", 7.25);
        milk = new Milk("Milk", 0.80);
        bogof = new BogofDiscount(milk);
        tenPercentOff = new TenPercentOffDiscount();
        loyaltyCard = new LoyaltyCardDiscount();
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

    @Test
    public void canAddDiscount() {
        basket.addDiscount(bogof);
        assertEquals(1, basket.getNumberOfDiscounts());
    }

    @Test
    public void canGetTotalDiscountWithBogof() {
        basket.addDiscount(bogof);
        basket.addItemsToBasket(milk);
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        assertEquals(0.8, basket.getTotalOfDiscount(), 0.01);
    }

    @Test
    public void canGetFinalTotalWithBogof() {
        basket.addDiscount(bogof);
        basket.addItemsToBasket(milk);
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        assertEquals(8.05, basket.getTotal(), 0.01);
    }

    @Test
    public void canGetTotalDiscountWithTenPercent() {
        basket.addDiscount(tenPercentOff);
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(brie);
        assertEquals(2.17, basket.getTotalOfDiscount(), 0.01);
        assertEquals(19.58, basket.getTotal(), 0.01);
    }
//    CAN APPLY ONE DISCOUNT BUT NEED TO WORK OUT HOW TO DO MORE AND IN ORDER!!!!

    @Test
    public void canGetTotalDiscountWithBogofAndTenPercent() {
        Brie brie2 = new Brie("Brie", 10.00);
        BogofDiscount bogof2 = new BogofDiscount(brie2);
        basket.addDiscount(bogof2);
        basket.addDiscount(tenPercentOff);
        basket.addItemsToBasket(brie2);
        basket.addItemsToBasket(brie2);
        basket.addItemsToBasket(brie2);
        basket.addItemsToBasket(brie2);
        basket.addItemsToBasket(brie2);
        assertEquals(27.00, basket.getTotal(), 0.01);
    }

    @Test
    public void canGetLoyaltyCard() {
        assertEquals(false, basket.hasLoyaltyCard());
    }

    @Test
    public void canAddLoyaltyCard() {
        basket.addLoyaltyCard();
        assertEquals(true, basket.hasLoyaltyCard());
    }

    @Test
    public void canGetTotalDiscountWithLoyaltyCard() {
        basket.addItemsToBasket(brie);
        basket.addItemsToBasket(milk);
        basket.addLoyaltyCard();
        basket.addDiscount(loyaltyCard);
        assertEquals(0.16, basket.getTotalOfDiscount(), 0.01);
        assertEquals(7.89, basket.getTotal(), 0.01);
    }
}
