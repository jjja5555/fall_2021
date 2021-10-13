package edu.northeastern.martin;

public class Car {
    private String name;
    private Wheels wheels;
    private GearBox gearBox;
    private Seats seats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public Car(String name, int wheelSize, boolean isAuto, int numSeats){
        this.name = name;
        wheels = new Wheels(wheelSize);
        gearBox = new GearBox(isAuto);
        seats = new Seats(numSeats);
    }
}
