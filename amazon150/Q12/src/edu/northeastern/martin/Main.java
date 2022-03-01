package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(intToRoman(3));
    }
    public static String intToRoman(int num) {
        int thousands = num/1000;
        int hundreds = (num%1000)/100;
        int tens = (num%100)/10;
        int ones = num%10;

        StringBuilder sb = new StringBuilder();
        //thousands
        for (int i = 0; i < thousands; i++) {
            sb.append('M');
        }

        //hundreds
        if(hundreds == 4){
            sb.append("CD");
        }else if(hundreds == 9){
            sb.append("CM");
        }else{
            if(hundreds >= 5){
                sb.append('D');
                hundreds -=5;
            }
            for (int i = 0; i < hundreds; i++) {
                sb.append('C');
            }
        }

        //tens
        if(tens == 4){
            sb.append("XL");
        }else if(tens == 9){
            sb.append("XC");
        }else{
            if(tens >= 5){
                sb.append('L');
                tens -= 5;
            }
            for (int i = 0; i < tens; i++) {
                sb.append('X');
            }
        }
        if(ones == 4){
            sb.append("IV");
        }else if(ones == 9){
            sb.append("IX");
        }else{
            if(ones >= 5){
                sb.append('V');
                ones -=5;
            }
            for (int i = 0; i < ones; i++) {
                sb.append('I');
            }
        }
        return sb.toString();
    }
}
