package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent2(arr,2));
        
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> res = new ArrayList<>();
        map.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() != o2.getValue()){
                    return o2.getValue().compareTo(o1.getValue());
                }else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        }).forEach(p -> res.add(p.getKey()));
        return res.subList(0,k);
    }
    public static List<String> topKFrequent2(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> map.get(a) == map.get(b) ? a.compareTo(b): map.get(b).compareTo(map.get(a)));
        for(String key : map.keySet()){
            queue.add(key);
            if(queue.size()> k){
                queue.poll();
            }
        }
        List <String> res = new ArrayList<>();
        for (String s : queue) {
            res.add(s);
        }
        return res;
    }
}
