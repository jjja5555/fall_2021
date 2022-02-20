package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here["talk","tons","fall","tail","gale","hall","negs"]
        List<String> list = new ArrayList<>();
        list.add("talk");
        list.add("tons");
        list.add("fall");
        list.add("tail");
        list.add("gale");
        list.add("hall");
        list.add("negs");
        System.out.println(ladderLength("talk","tail",list));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }
        Map<String,Set<String>> map = new HashMap<>();
        buildMap(wordList,map);
        if(map.size() == 0){
            return 0;
        }
        int time = 1;
        Queue<String> queue = new LinkedList<>();
        Map<String, Boolean> traveled = new HashMap<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Set<String> set = map.get(queue.poll());
                if(set != null){
                    for (String s : set) {
                        if(traveled.containsKey(s)){
                            continue;
                        }
                        if(s.equals(endWord)){
                            return time;
                        }
                        queue.add(s);
                        traveled.put(s,true);
                    }
                }

            }
        }
        return 0;
    }

    private static void buildMap (List<String> wordList,Map<String,Set<String>> map){
        for (String s : wordList) {
            for (String s1 : wordList) {
                if(isNeighbor(s,s1)){
                    Set<String> set = map.getOrDefault(s,new HashSet<>());
                    set.add(s1);
                    map.put(s,set);
                }
            }
        }
    }

    private static boolean isNeighbor(String a,String b){
        if(a == b){
            return false;
        }
        char [] aArray = a.toCharArray();
        char [] bArray = b.toCharArray();
        int diff = 0;
        for (int i = 0; i < aArray.length; i++) {
            if (aArray[i] != bArray[i]){
                diff++;
            }
            if(diff > 1){
                return false;
            }
        }
        return true;

    }
}
