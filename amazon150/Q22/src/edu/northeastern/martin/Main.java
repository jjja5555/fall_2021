package edu.northeastern.martin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(generateParenthesis(3));
    }
    private static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        addParenthesis(n, n,sb);
        return res;
    }

    private static void addParenthesis(int left,int right, StringBuilder sb) {
        if(left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }

        if(left == right){
            sb.append('(');
            addParenthesis(left-1,right,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                sb.append('(');
                addParenthesis(left-1,right,sb);
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(')');
            addParenthesis(left,right-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
