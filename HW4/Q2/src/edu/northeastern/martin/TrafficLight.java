package edu.northeastern.martin;

public class TrafficLight {

    private boolean road1IsGreen = true;
    public TrafficLight() {

    }

    public synchronized void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        if ((roadId == 1) != road1IsGreen) {
            turnGreen.run();
            road1IsGreen = !road1IsGreen;
        }
        crossCar.run();
    }
}
