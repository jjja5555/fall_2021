package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(maxProfit(new int[]{1,7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if(price <= min){
                min = price;
            }
            res = Math.max(price-min,res);
        }
        return  res;
    }
}
