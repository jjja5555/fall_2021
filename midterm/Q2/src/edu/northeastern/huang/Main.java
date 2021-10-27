package edu.northeastern.huang;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Printer p1;
        Printer p2;
        // refers to the only object of Database
        p1= Printer.getInstance();
        p2 = Printer.getInstance();
        Printer p3 = p2;

        //memory addresses are the same
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        p1.getConnection();
    }
}
