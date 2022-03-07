package edu.northeastern.martin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int n =  nums.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 0 ;i < n;i++){
            int dis = nums[i];
            for(int j = 1; j <= dis;j++){
                int index = i+j;
                if(index>=n)break;
                if(dp[index] == -1){
                    dp[index] = dp[i]+1;
                }else{
                    dp[index] = Math.min(dp[i]+1,dp[index]);
                }
            }
        }
        return dp[n-1];
    }
}
