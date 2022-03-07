package edu.northeastern.martin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(uniqueLetterString("ABA"));
    }

    public static int uniqueLetterString(String s) {
        int n = s.length();
        int [] chars =new int[26];
        int unique = 0;
        for(char c : s.toCharArray()){
            if(chars[c-'A'] ==0){
                unique++;
            }
            chars[c-'A']++;
        }
        int max = unique;

        for(int i = 0;i <=n;i++){
            if(i >0 && --chars[s.charAt(i-1)-'A'] ==0){
                unique--;
            }
            int tempCount = unique;
            int[]charsTemp = Arrays.copyOf(chars,26);
            for(int j = n-1;j > i;j--){
                if(j <n-1 && --charsTemp[s.charAt(j+1)-'A'] ==0){
                    tempCount--;
                }
                max+= tempCount;
            }
        }
        return max;
    }
}
