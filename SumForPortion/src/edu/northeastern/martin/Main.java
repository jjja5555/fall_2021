package edu.northeastern.martin;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

    public static int[] values = new int[50000000];
    public static long[] portionSum = new long[10];
    public static int portionSize = values.length/10;

    public static void main(String[] args) {
	// write your code here
        generateValues();
        Instant starts = Instant.now();

        System.out.println("Sum = " + getSum());

        Instant ends = Instant.now();
        System.out.println("Time taken = " + Duration.between(starts,ends).toMillis());


        Thread[] threads = new Thread[10];

        starts = Instant.now();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new calculateSum(i));
            threads[i].start();
        }

        //for
        for (int i = 0; i < threads.length; i++) {
            try{
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //while
        boolean isAllDead = false;
        int index = 0;
        while(isAllDead){
            if (!threads[index].isAlive()){
                System.out.println("thread finished: " + threads.getClass().getName());
            }
            if(index == 12){
                if(isAllDead){
                    break;
                }
                index = 0;
            }else{
                index++;
            }
        }
        int sum = 0;
        for (int i = 0; i < portionSum.length; i++) {
            sum+= portionSum[i];
        }
        ends = Instant.now();
        System.out.println("Sum = " + sum);
        System.out.println("Time taken = " + Duration.between(starts,ends).toMillis());
    }

    private static void generateValues(){
        Random rand = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(10);
        }
    }

    private static long getSum(){
        long sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
