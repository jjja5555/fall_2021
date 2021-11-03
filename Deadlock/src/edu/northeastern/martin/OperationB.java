package edu.northeastern.martin;

public class OperationB implements  Runnable{
    @Override
    public void run() {
        synchronized (Main.obj2){
            System.out.println("Operation 2 has got lock to obj2");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Main.obj1){
                System.out.println("Operation 2 has got lock to obj1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Operation 2 is leaving Obj1");
            }
            System.out.println("Operation 2 is leaving Obj2");
        }
    }
}
