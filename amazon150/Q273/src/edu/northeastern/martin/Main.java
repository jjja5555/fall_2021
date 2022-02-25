package edu.northeastern.martin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(numberToWords(1000000));
    }
    public static String numberToWords(int num) {
        if(num == 0)return"Zero";
        int [] map = new int[5];
        Arrays.fill(map,-1);
        int index = 0;
        while(num != 0){
            map[index++] = num%1000;
            num /= 1000;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 4; i >= 0; i--) {
            if(map[i]== -1 || map[i] ==0)continue;
            String suffix = "";
            switch(i){
                case 0: suffix = "";
                    break;
                case 1: suffix = "Thousand";
                    break;
                case 2: suffix = "Million";
                    break;
                case 3: suffix = "Billion";
                    break;
                case 4: suffix = "Trillion";
                    break;
            }
            sb.append(printUnderThousand(map[i]));
            sb.append(suffix+" ");
        }
        return sb.toString().trim();
    }

    public static String printUnderThousand(int num){
        StringBuilder sb = new StringBuilder();
        if(num>99){
            sb.append(printUnderThousand(num/100));
            sb.append("Hundred ");
            num %= 100;
        }
        if(num > 20){
            sb.append(printTen(num/10));
            if(num%10 != 0){
                sb.append(" ");
                sb.append(print1to9(num%10));
            }
            sb.append(" ");
        }else if(num >0){
            sb.append(print1to9(num));
            sb.append(" ");
        }

        return sb.toString();
    }
    public  static String printTen(int num){
        switch(num){
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    public static String print1to9(int num){
        switch(num){
            case 0: return "";
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            case 20: return "Twenty";
        }
        return " ";
    }
}
