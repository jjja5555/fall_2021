package edu.northeastern.martin;

public class TurnGreen implements Runnable{
    @Override
    public void run() {
        System.out.println("traffic light changes");
    }
}
