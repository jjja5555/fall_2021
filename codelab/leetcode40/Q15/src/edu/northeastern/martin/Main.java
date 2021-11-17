package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        int total = 0;
        boolean suffixC = false;
        boolean suffixX = false;
        boolean suffixI = false;
        for (char c : s.toCharArray()) {
            switch(c){
                case 'M':
                    if(suffixC){
                        total+= 800;
                        suffixC = !suffixC;
                    }else{
                        total += 1000;
                    }
                    break;
                case 'D':
                    if(suffixC){
                        total+= 300;
                        suffixC = !suffixC;
                    }else{
                        total += 500;
                    }
                    break;
                case 'C':
                    if(suffixX){
                        total+= 80;
                    }else{
                        total += 100;
                    }
                    suffixC = !suffixC;
                    break;
                case 'L':
                    if(suffixX){
                        total+= 30;
                        suffixX = !suffixX;
                    }else{
                        total += 50;
                    }
                    break;
                case 'X':
                    if(suffixI){
                        total+= 8;
                    }else{
                        total += 10;
                    }
                    suffixX = !suffixX;
                    break;
                case 'V':
                    if(suffixI){
                        total+= 3;
                        suffixI = !suffixI;
                    }else{
                        total += 5;
                    }
                    break;
                case 'I':
                    total += 1;
                    suffixI =!suffixI;
                    break;
            }
        }
        return total;
    }
}
