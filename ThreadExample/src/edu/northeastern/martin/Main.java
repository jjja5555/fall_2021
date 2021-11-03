package edu.northeastern.martin;

public class Main {
    public static long bankBalance;

    public static Object obj = new Object();
    public static void main(String[] args) {
	// write your code here
        Thread uni = new Thread(new AddMoneyToMyBank(5,2000));
        uni.setName("university");
        Thread micro = new Thread(new AddMoneyToMyBank(5,1000));
        micro.setName("micro");
        Thread uber = new Thread(new AddMoneyToMyBank(1,1000));
        uber.setName("uber");
        uni.start();
        micro.start();
        uber.start();

    }
}
