package edu.northeastern.martin;

import java.util.*;

public class RandomizedSet {

    HashMap<Integer,Integer> map = new HashMap<>();
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            map.put(list.get(list.size()-1),map.get(val));
            list.set(map.get(val),list.get(list.size()-1));
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
