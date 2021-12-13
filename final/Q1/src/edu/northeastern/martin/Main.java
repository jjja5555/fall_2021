package edu.northeastern.martin;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        int index = 0;
        while(index < sb.length()){
            if(sb.charAt(index) == '('){
                stack.push(index);
            }else if(sb.charAt(index) == ')' && !stack.empty()){
                stack.pop();
            }else if(sb.charAt(index) == ')' && stack.empty()){
                sb.deleteCharAt(index);
                index--;
            }
            index++;
        }
        while(!stack.empty()){
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }
}
