package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] strings  ={"eat","tea","tan","ate","nat","bat"};
        String [] emptyString = {""};
        System.out.println(groupAnagrams(strings));
        System.out.println(groupAnagrams(emptyString));

    }

    public static List<List<String>> groupAnagrams(String [] list){
        Map <String,List<String>> result = new HashMap<>();
        for (String s : list) {
            char [] chars = s.toCharArray();
            Arrays.sort(chars);
            String newStr = String.valueOf(chars);
            if(!result.containsKey(newStr)){
                List<String> newList = new ArrayList<>();
                newList.add(s);
                result.put(newStr, newList);
            }else{
                result.get(newStr).add(s);
            }
        }

        List<List<String>> output = new ArrayList<>();
        for (String s : result.keySet()) {
            output.add(result.get(s));
        }
        return output;
    }
}
