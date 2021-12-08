package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new Paypal("myemail@example.com"));
        cart.pay(new CreditCard( "1234567890123456"));
    }
}
