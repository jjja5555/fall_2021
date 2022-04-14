package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(candidates,target,res,deque,0);
        return res;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> deque, int index){
        if(target == 0){
            res.add(new ArrayList(deque));
        }

        for(int i = index; i < candidates.length;i++){
            int candidate = candidates[i];
            if(target < candidate)return;
            if(i > index && candidates[i] == candidates[i-1])continue;
            deque.addLast(candidate);
            dfs(candidates,target-candidate,res,deque,i+1);
            deque.removeLast();
        }
    }
}
