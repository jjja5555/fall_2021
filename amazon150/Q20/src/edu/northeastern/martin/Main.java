package edu.northeastern.martin;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack  =new Stack<>();
        for (char c : s.toCharArray()) {
            switch(c) {
                case ')':
                    if( stack.isEmpty()||stack.peek() != '('){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
                case '}':
                    if(stack.isEmpty()||stack.peek() != '{'){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;
                case ']':
                    if(stack.isEmpty()||stack.peek() != '['){
                        return false;
                    }else{
                        stack.pop();
                    }
                    break;

                default:
                    stack.push(c);
                    break;
            }

        }
        return stack.isEmpty();
    }
}
