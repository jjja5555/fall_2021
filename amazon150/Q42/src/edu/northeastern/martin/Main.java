package edu.northeastern.martin;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int a =  trap(new int[]{4,2,0,3,2,5});
        System.out.println(a);;
    }

    public static int trap(int[] height) {
        Stack<Integer>stack = new Stack<>();
        int res = 0;
        int heighest = 0;
        for (int num : height) {
            if(stack.isEmpty()){
                stack.push(num);
                heighest = num;
            }else{
                if(num > heighest){
                    while(!stack.isEmpty()){
                        res += heighest-stack.pop();
                    }
                    heighest = num;
                }
                stack.push(num);
            }
        }
        heighest = 0;
        while(!stack.isEmpty()){
            if(stack.peek() > heighest){
                heighest = stack.pop();
            }else{
                res += heighest - stack.pop();
            }
        }
        return res;
    }
}
