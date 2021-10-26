package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //multiply("123","123");
        System.out.println(multiply("123","456"));
    }

    public static String multiply(String num1, String num2) {
        int first = string2int(num1);
        int second = string2int(num2);
        return ""+(first*second);
    }
    private static int string2int(String num){
        char [] second = num.toCharArray();
        int result = 0;
        int n = 1;
        for (int i = second.length-1; i >=0; i--) {
            result += (second[i] -48) *n;
            n *=10;
        }
        return result;
    }

}
