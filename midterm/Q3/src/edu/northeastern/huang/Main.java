package edu.northeastern.huang;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] array = {1,3,-1,3,4,-1};
        System.out.println(sumRepeat(array));
    }

    public static int sumRepeat(int [] nums){
        int output = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j] && !map.containsKey(nums[i])){
                    map.put(nums[i],1);
                    output+=nums[i];
                }
            }
        }
        return output;
    }
}
