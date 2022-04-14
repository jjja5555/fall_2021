package edu.northeastern.martin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here[1,3,-1,-3,5,3,6,7]
        //3
        int [] arr = {9,10,9,-7,-4,-8,2,-6};
        int [] output = maxSlidingWindow(arr,5);
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0)return new int[] {};
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1,i2) -> nums[i2] -nums[i1]);
        int [] res = new int [n-k+1];
        int minI = 0;
        for(int i = 0 ; i < k;i++){
            pq.add(i);
        }
        int resIndex = 0;
        res[resIndex++] = nums[pq.peek()];
        for(int i = k; i < n;i++){
            pq.remove(minI++);
            pq.add(i);
            res[resIndex++] = nums[pq.peek()];
        }
        return res;
    }
}
