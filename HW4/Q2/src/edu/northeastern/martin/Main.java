package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        TrafficLight tf= new TrafficLight();
        tf.carArrived(1,2,3,new TurnGreen(),new CrossCar());
        tf.carArrived(1,1,2,new TurnGreen(),new CrossCar());
    }
}
