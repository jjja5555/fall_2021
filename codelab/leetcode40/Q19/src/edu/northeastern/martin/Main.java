package edu.northeastern.martin;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here

    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> check = new HashSet<Integer>();
        for (int num : nums) {
            if(check.contains(num)){
                return true;
            }else{
                check.add(num);
            }
        }
        return false;
    }
}
