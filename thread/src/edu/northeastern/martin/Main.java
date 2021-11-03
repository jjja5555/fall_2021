package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println(Thread.currentThread().getName());
//
//        int cores  = Runtime.getRuntime().availableProcessors();
//
//        System.out.println("nums of cores: " +cores);

        RunnableClass thClass = new RunnableClass();
        Thread th = new Thread(thClass);
        th.start();


    }
}
