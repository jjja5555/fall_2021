package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Rhino r1 = new Rhino("hx",10,10.0);
        r1.eat();
        System.out.println(r1.getName());

        Cat c1 = new Cat();
        c1.breathe();
        r1.breathe();

        Car beetle = new Car("beetle",17,true,4);
        beetle.setSeats(new Seats(2));
        System.out.println(beetle.getGearBox().isAuto());
        System.out.println(beetle.getName());
    }
}
