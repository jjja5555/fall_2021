package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isPalindron("abcba"));
    }

    private static boolean isPalindron(String input){
        if(input == null || input.length() <= 1){
            return true;
        }
        char [] arr = input.toCharArray();
        for(int i = 0; i < arr.length/2;i++){
            if(arr[i] != arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagrams(String str1, String str2){

        return false;
    }
}
