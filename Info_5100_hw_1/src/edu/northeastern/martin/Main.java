package edu.northeastern.martin;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Question 1
        int [] test = {0,2,3,4,400};
        System.out.println(sumUnique(test));
    }

    //Question1
    public static int sumUnique(int [] nums){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int num : nums) {
            if(map.containsKey(num)){
                if(map.get(num) != 0){
                    map.put(num,0);
                    sum -= num;
                }
            }else{
                map.put(num,1);
                sum += num;
            }
        }
        return sum;
    }

    //Question2
    public static int sumSquare(int [] nums){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int num : nums) {
            if(map.containsKey(num)){
                if(map.get(num) != 0){
                    map.put(num,0);
                    sum -= num;
                }
            }else{
                map.put(num,1);
                sum += num;
            }
        }
        return sum;
    }
}
