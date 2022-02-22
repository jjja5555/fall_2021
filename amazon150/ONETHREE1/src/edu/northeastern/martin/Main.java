package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] inputs = {"abcabcd","ababaa","aa"};
        for (int sum : commonPrefix(inputs)) {
            System.out.println(sum);
        }

        //2

        System.out.println(getMaxValue(new int[]{3,100,1,1,1000,1}));

        //3

        List<List<Integer>> list = new ArrayList<>(Arrays.asList(Arrays.asList(7,7),Arrays.asList(2,3),Arrays.asList(6,11),Arrays.asList(1,2)));
        List<List<Integer>> out = getMergedIntervals(list);

        //4

        List<Integer> intList= new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(evenSubarray(intList,2));
    }

    //common prefix
    public static int [] commonPrefix(String []  inputs){
        int [] res = new int[inputs.length];
        int index = 0;
        for (String input : inputs) {
            char [] arr = input.toCharArray();
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                String suffix = input.substring(i);
                sum+= countCommonPrefix(suffix,input);
            }
            res[index++] = sum;
        }
        return res;
    }

    private static int countCommonPrefix(String suffix, String origin){
        int count = 0;
        for (int i = 0; i < suffix.toCharArray().length; i++) {
            if(suffix.charAt(i) == origin.charAt(i)){
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    //c=automation

    public static int getMaxValue(int [] inputs){
        Arrays.sort(inputs);
        int pre = 1;
        for (int i = 0; i < inputs.length; i++) {
            int num = inputs[i];
            if(num >= pre){
                if(num - pre > 1){
                    num = pre+1;
                    inputs[i] = num;
                    pre++;
                }else if ( num - pre == 1){
                    pre++;
                }
            }

        }
        return inputs[inputs.length-1];
    }

    public static List<List<Integer>> getMergedIntervals(List<List<Integer>> intervals){
        intervals.sort((a,b)->a.get(0)-b.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).get(0) <= intervals.get(i-1).get(1)){
                intervals.get(i).set(0,intervals.get(i-1).get(0));
                intervals.get(i).set(1,Math.max(intervals.get(i-1).get(1),intervals.get(i).get(1)));
                intervals.remove(i-1);
                i--;
            }
        }
        return intervals;
    }

    public static int evenSubarray(List<Integer> numbers,int k){
        int len = numbers.size();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int odd = 0;
            int right = i;
            while(right < len){
                if(numbers.get(right)%2 == 1){
                    odd++;
                }
                if(odd <= k){
                    sum++;
                }
                right++;
            }
        }
        return sum;
    }
}
