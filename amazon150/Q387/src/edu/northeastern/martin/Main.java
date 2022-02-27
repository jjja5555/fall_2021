package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }

    public static int firstUniqChar(String s) {
        int n = s.length();
        int [] chars = new int[26];
        for (int i = 0; i < n; i++) {
            chars[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < n; i++) {
            if(chars[s.charAt(i)-'a'] ==1){
                return i;
            }
        }
        return -1;
    }
}
