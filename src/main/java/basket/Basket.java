package basket;

import discount.IDiscount;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Item> items;
    private ArrayList<IDiscount> discounts;

    public Basket(){
        items = new ArrayList<>();
        discounts = new ArrayList<>();
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
}
