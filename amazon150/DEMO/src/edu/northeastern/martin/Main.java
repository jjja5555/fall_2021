package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static List<List<Integer>> groupSort(List<Integer> arr) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (Integer key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(key);
            temp.add(map.get(key));
            res.add(temp);
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(2) - o1.get(2);
            }
        });
        return res;
    }

}
