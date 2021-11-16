package edu.northeastern.martin;

public class Main {

    public static Object obj1 = new Object();
    public static Object obj2 = new Object();

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Thread th1 = new Thread(new OperationA());
        Thread th2 = new Thread(new OperationB());
        th1.start();
        th1.sleep(4000);
        th2.start();
    }

}
