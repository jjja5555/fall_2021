package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(combinationSum4(new int[]{2,1,3},35));
    }

    public static int combinationSum4(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        return dfs(nums,target,0,map);
    }

    static int dfs(int[] nums,int target,int index,Map<Integer,Integer> map){
        if(target == 0){
            return 1;
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        int res= 0;
        for(int i = 0;i < nums.length;i++){
            int num = nums[i];
            if(num> target)continue;
            res += dfs(nums,target-num,i,map);

        }
        map.put(target,res);
        return res;
    }
}
