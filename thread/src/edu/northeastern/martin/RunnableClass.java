package edu.northeastern.martin;

public class RunnableClass implements Runnable{
    @Override
    public void run() {
        System.out.println("I am thread 1");
        System.out.println("I'm inside Thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            
        }
    }
}
