package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = groupAnagrams(strs);
        System.out.println(output);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String,List<String>> storage = new HashMap<>();
        for (String str : strs) {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(storage.containsKey(key)){
                storage.get(key).add(str);
            }else{
                storage.put(key,new ArrayList<>());
                storage.get(key).add(str);
            }
        }
        for (String s : storage.keySet()) {
            output.add(storage.get(s));
        }
        return output;
    }
}
