package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] banned = {"hit"};

        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",banned));
    }

    //brute force
    public static String mostCommonWord(String paragraph, String[] banned) {
        char [] chars = paragraph.toCharArray();
        String word = "";
        Map<String,Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if(aChar < 65 && !word.equals("")){
                //
                boolean isBanned = false;
                for (String s : banned) {
                    if(s.equals(word)){
                        isBanned = true;
                        break;
                    }
                }
                if(!isBanned){
                    map.put(word,map.getOrDefault(word,0)+1);
                }
            }else if(aChar <= 90  && aChar>= 65){
                aChar = Character.toLowerCase(aChar);
                word+= aChar;
                continue;
            }else if(aChar>= 97 && aChar <= 122){
                word+= aChar;
                continue;
            }
            word = "";
        }
        if(!word.equals("")){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        String outWord = "";
        int count = 0;
        for (String s : map.keySet()) {
            if(map.get(s) > count){
                count = map.get(s);
                outWord = s;
            }
        }
        return outWord;
    }
}
