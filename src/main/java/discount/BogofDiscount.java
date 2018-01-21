package discount;

import basket.Item;

import java.util.ArrayList;

public class BogofDiscount implements IDiscount {

    private Item itemToDiscount;

    public BogofDiscount(Item itemToDiscount){
        this.itemToDiscount = itemToDiscount;
    }

//        loop items
//        if two items have same name add item to new ArrayList
//        delete down to half
//        get all prices and total

    public ArrayList<Item> createListToApplyDiscount(ArrayList<Item> items) {
        ArrayList<Item> itemsToApplyDiscountTo = new ArrayList<>();
        for (Item item : items) {
            if (item == itemToDiscount) {
                itemsToApplyDiscountTo.add(item);
            }
        }
        return itemsToApplyDiscountTo;
    }

    @Override
    public double applyDiscount(ArrayList<Item> items) {
        double finalPrice = 0;
        ArrayList<Item> itemsToCalculate = createListToApplyDiscount(items);
        int finalNumberOfItems = itemsToCalculate.size() % 2;
        for (Item item : itemsToCalculate) {
            double price = item.getPrice() * finalNumberOfItems;
            finalPrice += price;
        }
        return finalPrice;
    }

}
