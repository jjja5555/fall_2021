package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("hello","llo"));
    }
    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()){
            return -1;
        }
        if(needle.equals("")){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if (j == needle.length()-1){
                    return i;
                }
            }
        }
        return -1;
    }
}
