package basket;

import discount.IDiscount;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items;
    private ArrayList<IDiscount> discounts;
    private double total;

    public Basket(){
        items = new ArrayList<>();
        discounts = new ArrayList<>();
        total = 0;
    }

    public int countItemsInBasket() {
        return items.size();
    }

    public void addItemsToBasket(Item item){
        items.add(item);
    }

    public void deleteItemFromBasket(Item item) {
        items.remove(item);
    }

    public void emptyBasket() {
        items.clear();
    }

    public double getTotal() {
        for (Item item : items){
            double price = item.getPrice();
            total += price;
        }
        return total;
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public int getNumberOfDiscounts() {
        return discounts.size();
    }

    public void addDiscount(IDiscount discount){
        discounts.add(discount);
    }
}
