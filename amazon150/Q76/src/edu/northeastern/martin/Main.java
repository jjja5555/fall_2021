package edu.northeastern.martin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(minWindow("ADOBECODEBANCC","ABCC"));
        System.out.println(minWindow("ab","A"));
    }

    public static String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }else if(t.length() == s.length() && t.length() == 1  && !s.equals(t)){
            return "";
        }
        int n = s.length();

        //to store count of each unique Character
        int [] tChars = new int[150];
        int tCount = 0;

        //use for sliding window
        int [] windowChars = new int[150];
        int windowCount = 0;

        //fill t char array
        for (char c : t.toCharArray()) {
            tChars[c]++;
            tCount++;
        }


        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = s.length();
        String res = "";
        while(right < n){
            char c = s.charAt(right);
            if(tChars[c] >windowChars[c]){
                windowCount++;
            }
            windowChars[c]++;
            while(windowCount == tCount && left <= right){
                if(right-left <minRight-minLeft){
                    minRight = right;
                    minLeft = left;
                    res = s.substring(left,right+1);
                }
                char charLeft = s.charAt(left);
                left++;
                windowChars[charLeft]--;
                if(windowChars[charLeft] < tChars[charLeft]){
                    windowCount--;
                    break;
                }
            }
            right++;
        }

        return res;
    }

}
