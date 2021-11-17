package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(countBinarySubstrings("001100011"));
    }

    public static int countBinarySubstrings(String s) {
        int count = 0;
        int index =0;
        int countF = 0;
        int countS = 0;
        char temp = s.charAt(0);
        while(index < s.length()){
            if(s.charAt(index) != temp){
                temp = s.charAt(index);
                count+= Math.min(countF,countS);
                countF = countS;
                countS = 0;
            }else{
                countS++;
                index++;
            }

        }
        count+= Math.min(countF,countS);
        return count;
    }
}
