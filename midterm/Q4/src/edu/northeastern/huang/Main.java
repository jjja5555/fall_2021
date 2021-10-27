package edu.northeastern.huang;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "abcd123456789";
        System.out.println(longestSubstring(s));
    }

    public static String longestSubstring(String input){
        String max = "";
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < input.toCharArray().length; i++) {
            String substring = "";
            for (int j = i; j < input.toCharArray().length; j++) {
                if(!substring.contains(String.valueOf(input.charAt(j)))) {
                    substring += input.charAt(j);
                }else{
                    break;
                }
            }
            if(substring.length() > max.length()){
                max = substring;
            }
        }
        return max;
    }
}
