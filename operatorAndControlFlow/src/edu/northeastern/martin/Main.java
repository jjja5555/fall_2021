package edu.northeastern.martin;

public class Main {

    public static final int globalInt = 5;//don't do this

    public static void main(String[] args) {
	    // operator basic
        int a = 16;
        int b = 3;
        int add = a+b;
        int minus = a-b;
        int times = a*b;
        int devide = a/b;
        int remain = a%b;
        System.out.println(add);
        System.out.println(minus);
        System.out.println(times);
        System.out.println(devide);
        System.out.println(remain);

        //basic + = && !
        a += 2;
        b -= 2;
        boolean bValue = true;
        bValue = !bValue;
        System.out.println(a);//18
        System.out.println(b);//1
        System.out.println(bValue);
        System.out.println(++a);//19
        System.out.println(a--);//19
        System.out.println(a);//18

        if(!bValue){
            System.out.println("Remember to write cirly bracket");
        }

        a = 5;
        a = ~a;
        a += 1;
        System.out.println(a);

        //array
        byte [] arr = new byte [5];
        System.out.println(arr.length);
        arr[0] = 1;
        arr[1] = -3;
        arr[2] = 9;
        arr[3] = 10;
        arr[4] = 127;
        System.out.println(arr[4]);
        for (byte b1 : arr) {
            System.out.println(b1);
        }

        boolean [] bValues = {true,false,false,true};

        for (boolean value : bValues) {
            System.out.println(value);
        }

        char [] name = {'h','u','a','n','g'};

        System.out.println(name);
        String nameString = String.valueOf(name);
        System.out.println(nameString);

        String firstName = "Xiao";
        String lastName = "Huang";
        System.out.println(firstName.charAt(0));
        System.out.println(firstName.toCharArray()[0]);

        StringBuilder sb = new StringBuilder();
        sb.append(firstName + " ");
        sb.append(lastName);
        String sql = sb.toString();
        System.out.println(sql);
        System.out.println(nameSum(firstName,lastName));
    }// End of main

    private static String nameSum(Object firstName, Object lastName){
        StringBuilder sb = new StringBuilder();
        sb.append(firstName + " ");
        sb.append(lastName);
        return sb.toString();
    }


}//End of Class
