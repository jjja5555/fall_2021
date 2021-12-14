package edu.northeastern.martin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(convert("PAYPALISHIRING",4));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1)return s;
        String [] storage = new String[numRows];
        Arrays.fill(storage, "");
        int index = 0;
        boolean direction = true;
        for (int i = 0; i < s.toCharArray().length; i++) {
            storage[index] += s.charAt(i);
            if(i%(numRows - 1) == 0 && i != 0){
                direction = !direction;
            }
            if(direction){
                index++;
            }else{
                index--;
            }
        }
        String output = "";
        for (String s1 : storage) {
            output+= s1;
        }
        return output;
    }
}
