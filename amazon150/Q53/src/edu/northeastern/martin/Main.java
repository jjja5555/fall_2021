package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int preMax = 0;
        int max = nums[0];
        for(int num : nums){
            if(num+preMax > num){
                preMax = num+preMax;
            }else{
                preMax = num;
            }
            if(preMax > max){
                max = preMax;
            }

        }
        return max;
    }

}
