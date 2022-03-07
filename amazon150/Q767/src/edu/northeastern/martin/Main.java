package edu.northeastern.martin;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(reorganizeString("aabbb"));
    }

    public static String reorganizeString(String s) {
        int n = s.length();
        int [] chars =new int[26];
        char [] arr = s.toCharArray();
        for(char c: arr){
            chars[c-'a']++;
            if(chars[c-'a'] > (n+1)/2)return "";
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->chars[o2] - chars[o1]);
        for (int i = 0; i < 26; i++) {
            if(chars[i] >0){
                pq.add(i);
            }
        }
        char [] res = new char[n];
        for(int i = 0; i < n;i+=2){
            int c = pq.peek();
            if(chars[c] >0){
                res[i] = (char) (c+'a');
                chars[c]--;
                if(chars[c] ==0){
                    pq.poll();
                }
            }
        }

        for(int i = 1; i < n;i+=2){
            int c = pq.peek();
            if(chars[c] >0){
                res[i] = (char) (c+'a');
                chars[c]--;
                if(chars[c] ==0){
                    pq.poll();
                }
            }
        }

        return String.valueOf(res);
    }
}
