package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3},2));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i ++){
            int num = nums[i];
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Integer key : map.keySet()) {
            int num = key;
            int count = map.get(key);
            if(pq.size() == k){
                if(pq.peek()[1] < count){
                    pq.poll();
                    pq.add(new int [] {num,count});
                }
            }else{
                pq.add(new int [] {num,count});
            }
        }
        int [] res = new int[k];
        for (int i = k-1; i >=0; i--) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
