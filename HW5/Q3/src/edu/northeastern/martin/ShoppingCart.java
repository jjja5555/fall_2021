package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> list;
    public ShoppingCart() {
        list = new ArrayList<>();
    }

    public void addItem(Item item){
        this.list.add(item);
    }

    public void removeItem(Item item){
        this.list.remove(item);
    }

    public int calculateTotal(){
        int total = 0;
        for (Item item : list) {
            total+= item.getPrice();
        }
        return total;
    }
    public void pay(PaymentStrategy paymentStrategy){
        paymentStrategy.pay(this.calculateTotal());
    }
}
