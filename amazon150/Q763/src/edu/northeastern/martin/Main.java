package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> list = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(list);
    }

    public static List<Integer> partitionLabels(String s) {
        int [] lastIndex = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
                lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int endIndex = 0;
        int startIndex = 0;
        for (int i = 0; i < len; i++) {
            endIndex = Math.max(lastIndex[s.charAt(i) -'a'],endIndex);
            if(i == endIndex){
                res.add(endIndex-startIndex+1);
                startIndex = endIndex+1;
            }
        }
        return res;
    }
}
