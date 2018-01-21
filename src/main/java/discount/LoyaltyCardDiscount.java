package discount;

import basket.Item;

import java.util.ArrayList;

public class LoyaltyCardDiscount implements IDiscount {

    @Override
    public double applyDiscount(ArrayList<Item> items) {
        double total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        return (total*2)/100;
    }
}
