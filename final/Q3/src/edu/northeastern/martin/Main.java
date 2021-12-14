package edu.northeastern.martin;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> times = new Stack();
        Stack<String> result = new Stack();
        int multi = 0;
        String output = "";
        for (char c : s.toCharArray()) {
            if(c == '['){
                times.push(multi);
                result.push(output);
                multi = 0;
                output = "";
            }else if(c == ']'){
                output = result.pop() + output.repeat(times.pop());
            }else if (c >= '0' && c <= '9'){
                multi = multi*10 + (c -48);
            }else{
                output+=c;
            }
        }
        return output;
    }


}
