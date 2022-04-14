package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static int findPeakElement(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]){
                index = i;
            }
        }
        nums[nums]
        return index;
    }
}
