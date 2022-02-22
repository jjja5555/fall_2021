package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] inputs = {"abcabcd","ababaa","aa"};
        for (int sum : commonPrefix(inputs)) {
            System.out.println(sum);
        }
    }

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
}
