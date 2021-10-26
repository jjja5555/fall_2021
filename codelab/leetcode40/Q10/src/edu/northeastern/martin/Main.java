package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int length = nums.length;
        if(nums == null || length < 3){
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if(nums[i] > 0 ){
                break;

            }
            if( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else if (sum >0){
                    right--;
                }
            }
        }
        return ans;


    }
}
