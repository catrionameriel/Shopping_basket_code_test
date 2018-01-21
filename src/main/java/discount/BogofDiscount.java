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
//        What is prices are different? SORT LATER

    public ArrayList<Item> createListToApplyDiscount(ArrayList<Item> items) {
        ArrayList<Item> itemsToApplyDiscountTo = new ArrayList<>();
        for (Item item : items) {
            if (item.equals(itemToDiscount)) {
                itemsToApplyDiscountTo.add(item);
            }
        }
        return itemsToApplyDiscountTo;
    }

    @Override
    public double applyDiscount(ArrayList<Item> items) {
        double finalPriceToDeduct = 0;
        ArrayList<Item> itemsToCalculate = createListToApplyDiscount(items);
        double finalNumberOfItems = itemsToCalculate.size() / 2;
        double price = items.get(0).getPrice() * finalNumberOfItems;
        finalPriceToDeduct += price;
        return finalPriceToDeduct;
    }

}
