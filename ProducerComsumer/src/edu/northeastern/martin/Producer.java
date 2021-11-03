package edu.northeastern.martin;

public class Producer implements Runnable{
    @Override
    public void run() {
        while(true){
            synchronized (Main.obj){
                Main.items.add(Thread.currentThread().getName()+"add item");
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
