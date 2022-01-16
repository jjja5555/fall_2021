package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum+=i - nums[i-1];
        }
        return sum;

    }
}
