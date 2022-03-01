package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","catcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            int len = word.length();
            boolean [] dp = new boolean[len+1];
            dp [0] = true;
            boolean found = false;
            for (int i = 0; i < len; i++) {
                for (int j = i+1; j <= len ; j++) {
                    if(dp[i] == true && set.contains(word.substring(i,j))){
                        dp[j] = true;
                        if(j == len && i !=0){
                            res.add(word);
                            found = true;
                            break;
                        }
                    }
                }
                if(found){
                    break;
                }
            }
        }
        return res;
    }
}
