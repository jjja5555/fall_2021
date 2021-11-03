package edu.northeastern.martin;


import java.util.Random;

public class Consumer implements Runnable{
    @Override
    public void run() {
        Random rand = new Random();
        while (true){
            if(Main.items.size() > 0){
                System.out.println(Thread.currentThread().getName() + "buy " + Main.items.remove(0));
                System.out.println(Main.items.size());
                try {
                    Thread.sleep(rand.nextInt(19));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
