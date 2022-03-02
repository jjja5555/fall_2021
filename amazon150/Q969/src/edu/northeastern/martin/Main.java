package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr = {1,2,3};
        System.out.println(pancakeSort(arr));
    }


    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int max = arr.length;
        while(max>0){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == max){
                    if(i == 0){
                        helper(arr,max);
                        res.add(max);
                    }else{
                        helper(arr,i+1);
                        res.add(i+1);
                        helper(arr,max);
                        res.add(max);
                    }
                    max--;
                    break;
                }
            }
        }
        return res;
    }

    private static void helper (int[]arr,int k){
        for (int i = 0; i < k/2; i++) {
            int temp = arr[i];
            arr[i] = arr[k-i-1];
            arr[k-i-1] = temp;
        }
    }

    //3241
    //4231
    //1324
}
