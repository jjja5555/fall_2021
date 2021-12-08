package edu.northeastern.martin;

public class CreditCard implements PaymentStrategy{
    String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paypal : $" + amount);
    }
}
