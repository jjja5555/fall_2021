package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List <String> list = new ArrayList<>(Arrays.asList(new String[]{"apple", "pen"}));
        System.out.println(wordBreak("applepenapple",list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if(dp[i] && set.contains(s.substring(i,j))){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
