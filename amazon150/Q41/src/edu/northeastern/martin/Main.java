package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n;i++){
            if(nums[i] <=0){
                nums[i] = n+1;
            }
        }

        for(int i = 0 ; i < n;i++){
            int num = Math.abs(nums[i]);
            if(num <=n){
                nums[num-1] = -nums[num-1];
            }
        }

        for(int i = 0 ; i < n;i++){
            if(nums[i] >0){
                return i+1;
            }
        }
        return n+1;
    }
}
