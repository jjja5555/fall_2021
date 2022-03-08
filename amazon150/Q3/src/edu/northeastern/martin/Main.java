package edu.northeastern.martin;

import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(lengthOfLongestSubstring2("dvdf"));
    }

    //brute force
    public static int lengthOfLongestSubstring(String s) {
        char [] arr = s.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int tempLength = 0;
            char [] map = new char[200];
            for (int j = i; j < arr.length; j++) {
                if(map[arr[j]] != 0){
                    maxLength = Math.max(maxLength,tempLength);
                    break;
                }
                map[arr[j]] =1;
                tempLength++;
                if(j == arr.length-1){
                    maxLength = Math.max(maxLength,tempLength);
                }

            }
        }
        PriorityQueue<String> queue = new PriorityQueue<>();
        return maxLength;

    }

    //window
    public static int lengthOfLongestSubstring2(String s) {
        char [] arr = s.toCharArray();
        int maxLength = 0;
        int tempLength = 0;
        int [] map = new int[200];
        Arrays.fill(map,-1);
        for (int i = 0; i < arr.length; i++) {
            if(map[arr[i]]!= -1){
                maxLength = Math.max(maxLength,tempLength);
                tempLength = 0;
                i = map[arr[i]];
                Arrays.fill(map,-1);
                continue;

            }
            map[arr[i]] = i;
            tempLength++;
            if(i == arr.length-1){
                maxLength = Math.max(maxLength,tempLength);
            }
        }
        return maxLength;
    }
}
