package edu.northeastern.martin;

public class Paypal implements PaymentStrategy{
    String email;

    public Paypal(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("CreditCard : $" + amount);
    }
}
