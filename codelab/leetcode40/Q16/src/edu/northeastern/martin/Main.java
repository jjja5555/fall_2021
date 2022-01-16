package edu.northeastern.martin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] nums = {-1,1,-6,4,5,-6,1,4,1};
        int [] newNums = frequencySort(nums);
        System.out.println();
    }

    public static int[] frequencySort(int[] nums) {
        int [] storage = new int[202];
        for (int num : nums) {
            storage[num+100]++;
        }
        Arrays.sort(nums);
        for (int i = nums.length-1; i >=0; i--) {
            nums[i] = 10000 * storage[nums[i]+100]-nums[i]+200;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i]%=10000;
            nums[i] = 200 - nums[i];
        }
        return nums;
    }
}
