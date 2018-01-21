package discount;

import basket.Item;

import java.util.ArrayList;

public class BogofDiscount implements IDiscount {

    @Override
    public double applyDiscount(ArrayList<Item> items) {
        return 0;
    }
}
