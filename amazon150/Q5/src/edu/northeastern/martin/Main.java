package edu.northeastern.martin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(longestPalindromeDP("babad"));
    }

    //brute force
    public static String longestPalindromeBF(String s) {
        if(s.length() < 2){
            return s;
        }
        char [] arr = s.toCharArray();
        int maxLen = 1;
        int begin= 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(isPalindrome(arr,i,j) && j - i + 1> maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin +maxLen);
    }

    private static boolean isPalindrome(char []p , int left, int right){
        while(left < right){
            if(p[left] != p[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //中心扩散
    public static String longestPalindromeCenter(String s) {
        if (s.length() < 2){
            return s;
        }
        char [] arr = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < arr.length-1; i++) {
            int oddLen = expandCenter(arr,i,i);
            int evenLen = expandCenter(arr,i,i+1);
            int max = Math.max(oddLen,evenLen);
            if(max > maxLen){
                begin = i -(max -1)/2;
                maxLen = max;
            }
        }
        return s.substring(begin,begin+maxLen);

    }

    private static int expandCenter(char[] arr, int i, int j) {
        int len = arr.length;
        int left = i;
        int right = j;
        while(left >= 0 && right < len){
            if(arr[left] == arr[right]){
                left--;
                right++;
            }else{
                break;
            }
        }
        return right -left -1;
    }

    //中心扩散
    public static String longestPalindromeDP(String s) {
        if (s.length() < 2){
            return s;
        }
        int len = s.length();
        char [] arr = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        boolean [][]dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if(arr[i] != arr[j]){
                    dp[i][j] =false;
                }else{
                    //if there is only one or no element between i and j
                    if(j-i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j - i+1 >maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);

    }

}
