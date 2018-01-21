package discount;

import basket.Item;

import java.util.ArrayList;

public class TenPercentOffDiscount implements IDiscount{

    @Override
    public double applyDiscount(ArrayList<Item> items) {
        double total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        if (total >= 20.00){
           return total/10;
        }
        return 0.00;
    }
}
