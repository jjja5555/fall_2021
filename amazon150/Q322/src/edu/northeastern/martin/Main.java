package edu.northeastern.martin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(coinChange(new int [] {1,2,5},11));
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int []dp = new int[max];
        Arrays.fill(dp,amount+1);
        dp[0] =0;

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if(i >= coin){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
