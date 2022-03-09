package edu.northeastern.martin;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length+2;
        int [] arr = new int[n];
        for(int i = 0; i < n-2;i++){
            arr[i+1] = heights[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        int res = 0;
        for(int i = 1; i < n;i++){
            while(arr[deque.peekLast()] > arr[i]){
                int height = arr[deque.pollLast()];
                int width = i- deque.peekLast()-1;
                res = Math.max(res,height* width);
            }
            deque.addLast(i);
        }
        return res;
    }
}
