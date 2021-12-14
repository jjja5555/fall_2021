package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] output = productExceptSelf(new int [] {1,2,3,4});
        System.out.println();
    }

    public static int[] productExceptSelf(int[] nums) {
        int left =1;
        int right =1;
        int []leftA = new int[nums.length];
        int []rightA = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            leftA[i] = left*nums[i-1];
            left = left*nums[i-1];
        }
        for (int i = nums.length-2; i >=0; i--) {
            rightA[i] = right*nums[i+1];
            right = right*nums[i+1];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) {
            if(i == 0){
                output[i] =rightA[i];
            }else if(i == output.length-1){
                output[i] =leftA[i];
            }
            else{
                output[i] = leftA[i]*rightA[i];
            }
        }
        return output;
    }
}
