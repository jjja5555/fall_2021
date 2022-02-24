package edu.northeastern.martin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    static class Node {
        char c;
        int count;
        Node prev;


        public Node(int count) {
            this.count = count;
            this.prev = null;
        }
        public Node(char c,int count) {
            this.c = c;
            this.count = count;
            this.prev = null;
        }
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(minimumKeypadClickCount("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(countMaximumOperations("mononom","mon"));
        System.out.println(countMaximumOperationsSubString("mononom","no"));

        //Subsequence
        //System.out.println(countMaximumOperationsSubSequence("moonnonno","onn"));
        System.out.println(countMaximumOperationsSubSequenceMulti("moonnonno","ono"));
    }

    //九宫格

    public static int minimumKeypadClickCount (String text){
        Map<Character,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < text.toCharArray().length; i++) {
            map.put(text.charAt(i),map.getOrDefault(text.charAt(i),0)+1);
            if(map.size() <= 9){
                sum++;
            }else if (map.size() >9 && map.size() <= 18){
                sum++;
                sum++;
            }else{
                sum++;
                sum++;
                sum++;
            }
        }
        return sum;

    }

    //无顺序要求
    public static int countMaximumOperations (String s, String t){
        int sum = Integer.MAX_VALUE;
        int [] sCount = new int[26];
        int [] tCount = new int[26];
        for (int i = 0; i < s.toCharArray().length; i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            tCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(tCount[i] >0){
                sum = Math.min(sCount[i]/tCount[i],sum);
            }
        }
        return sum;
    }

    public static int countMaximumOperationsSubString(String s, String t){
        int sum = 0;
        int tIndex = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if(s.charAt(i) == t.charAt(tIndex)){
                tIndex++;
            }else{
                tIndex = 0;
            }
            if(tIndex == t.length()){
                sum++;
                tIndex = 0;
            }
        }
        return sum;
    }

    public static int countMaximumOperationsSubSequence(String s, String t){
        Map<Character,Node> map = new HashMap<>();
        Node prevNode = null;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Node temp = new Node(0);
            temp.prev = prevNode;
            map.put(c,temp);
            prevNode = temp;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c).prev != null){
                    if(map.get(c).count < map.get(c).prev.count){
                        map.get(c).count++;
                    }
                }else{
                    map.get(c).count++;
                }
            }
        }
        int out = map.get(t.charAt(t.length()-1)).count;
        return out;
    }

    public static int countMaximumOperationsSubSequenceMulti(String s, String t){
        //count for each char in t
        char [] sArr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < sArr.length; i++) {
            int j = i;
            int tIndex = 0;
            while(j < s.length() && tIndex < t.length()){
                if(sArr[j] == t.charAt(tIndex)){
                    sArr[j] = '*';
                    tIndex++;
                }
                j++;
            }
            sum += tIndex == t.length()? 1:0;
        }
        return sum;
    }
}
