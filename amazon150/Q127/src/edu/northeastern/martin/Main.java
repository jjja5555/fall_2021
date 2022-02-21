package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here["talk","tons","fall","tail","gale","hall","negs"]
        //"hot","dot","dog","lot","log","cog"
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
//        list.add("lot");
//        list.add("log");
//        list.add("cog");
        System.out.println(ladderLength("a","c",list));
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
        int startTime = 0;
        int endTime = 1;
        Queue<String> startQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        Map<String, Integer> traveled = new HashMap<>();
        startQueue.add(beginWord);
        endQueue.add(endWord);
        while(!startQueue.isEmpty() || !endQueue.isEmpty()){
            startTime++;
            int size = startQueue.size();
            for (int i = 0; i < size; i++) {
                Set<String> set = map.get(startQueue.poll());
                if(set != null){
                    for (String s : set) {
                        if(traveled.containsKey(s)) {
                            int flag = traveled.get(s);
                            if (flag== 1) {
                                continue;
                            } else if (flag == -1){
                                return startTime+endTime;
                            }
                        }
                        if(s.equals(endWord)){
                            return startTime;
                        }
                        startQueue.add(s);
                        traveled.put(s,1);
                    }
                }

            }
            endTime++;
            size = endQueue.size();
            for (int i = 0; i < size; i++) {
                Set<String> set = map.get(endQueue.poll());
                if(set != null){
                    for (String s : set) {
                        if(traveled.containsKey(s)) {
                            int flag = traveled.get(s);
                            if (flag== -1) {
                                continue;
                            } else if (flag == 1){
                                return startTime+endTime -1;
                            }
                        }
                        endQueue.add(s);
                        traveled.put(s,-1);
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
