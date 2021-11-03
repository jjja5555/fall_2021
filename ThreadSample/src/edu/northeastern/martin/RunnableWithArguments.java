package edu.northeastern.martin;

public class RunnableWithArguments implements Runnable{
    int value;
    public RunnableWithArguments(int i) {
        this.value = i;
    }

    @Override
    public void run() {
        System.out.println(value);
    }
}
