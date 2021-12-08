package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ICar sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();

        System.out.println();

        ICar sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
