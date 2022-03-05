package edu.northeastern.martin;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(largestRectangleArea(new int[]{3,6,5,7,4,8,1,0}));
    }

//    public static int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            int minHeights = Integer.MAX_VALUE;
//            for (int j = i; j < n; j++) {
//                if(heights[j] < minHeights){
//                    minHeights = heights[j];
//                }
//                max = Math.max((j-i+1)* minHeights,max);
//            }
//        }
//        return max;
//    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for(int i = 1; i < heights.length;i++){
            int height = heights[i];
            int stackIndex;
            while(!stack.isEmpty() && height < heights[stack.peek()]){
                stackIndex = stack.pop();
                if(stack.isEmpty()){
                    max = Math.max(heights[stackIndex]* (i),max);
                }else{
                    max = Math.max(heights[stackIndex]* (i-stack.peek()-1),max);
                }

            }
            stack.push(i);
        }

        int n = heights.length-1;
        while(!stack.isEmpty()){

            int stackIndex = stack.pop();
            if(stack.isEmpty()){
                max = Math.max(heights[stackIndex]* (n),max);
            }else{
                max = Math.max(heights[stackIndex]* (n-stack.peek()),max);
            }
        }
        return max;
    }
}
