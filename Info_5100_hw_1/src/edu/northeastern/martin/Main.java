package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Question 1
        System.out.println("Question1: ");
        int [] test1 = {0,2,3,4,400};
        System.out.println(sumUnique(test1));
        System.out.println();

        //Question 2
        System.out.println("Question2: ");
        int [] test2 = {-11,-10,-5,3,4,5,11};
        for (int num : sumSquare(test2)) {
            System.out.println(num);
        }
        System.out.println();

        //Question 3
        System.out.println("Question3: ");
        int [] test3 = {2,3,3,4,2,2,4,400,1,12,400};
        System.out.println(findFirstNonRepeat(test3));
        System.out.println();

        //Question 4
        System.out.println("Question4: ");
        System.out.println(ransomNote("abcd","abde"));
        System.out.println();

        //Question
        System.out.println("Question5: ");
        System.out.println(checkPattern("1A2n3m"));
        System.out.println();

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
    public static int[] sumSquare(int [] nums){
        if(nums[0] >= 0){
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i]* nums[i];
            }
            return  nums;
        }else{
            int [] result = new int[nums.length];
            int resultCursor = nums.length-1;
            for (int i = 0, j = nums.length-1; i < j; i++, j--) {
                if(nums[i] * nums[i]< nums[j]* nums[j]){
                    result[resultCursor] = nums[j] * nums[j];
                    resultCursor--;
                    result[resultCursor--] = nums[i] * nums[i];
                }else{
                    result[resultCursor] = nums[i] * nums[i];
                    resultCursor--;
                    result[resultCursor--] = nums[j] * nums[j];
                }
            }
            return result;
        }
    }

    //Question3
    public static int findFirstNonRepeat(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            boolean isNonRepeat = true;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == nums[i] && i != j){
                    isNonRepeat = false;
                    break;
                }
            }
            if(isNonRepeat){
                return nums[i];
            }

        }
        return -1;
    }

    public static boolean ransomNote(String product, String produce){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (char c : produce.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }

        for (char c : product.toCharArray()) {
            if(!map.containsKey(c)){
                return false;
            }
            int count = map.get(c);
            if(count == 0){
                return false;
            }
            map.put(c,count-1);
        }
        return true;
    }

    //Question 5
    public static boolean checkPattern(String input){
        char first = input.charAt(0);
        if(first< 58 && first>47){
            for (int i = 0; i < input.toCharArray().length; i=i+2) {
                if(input.charAt(i) >= 58 && input.charAt(i) <= 47){
                    return false;
                }
            }
            for (int i = 1; i < input.toCharArray().length; i=i+2) {
                if(input.charAt(i) < 65 || input.charAt(i) >122){
                    return false;
                }
            }
        }else{
            for (int i = 1; i < input.toCharArray().length; i=i+2) {
                if(input.charAt(i) >= 58 && input.charAt(i) <= 47){
                    return false;
                }
            }
            for (int i = 0; i < input.toCharArray().length; i=i+2) {
                if(input.charAt(i) < 65 || input.charAt(i) >122){
                    return false;
                }
            }
        }
        return true;
    }
}
