package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
        House h1 = new House();
        h1.setColor("White");
        h1.setHouseNum(1);
        h1.setNumOfBeds(2);
        h1.setNumOfBaths(2);
        h1.setOwner(new Person());
        System.out.println(h1.isSold());
        House h2 = new House(1, "Gold", 3, 2.5);
        System.out.println(h2.getColor());

        Person p1 = new Person();
        h2.setOwner(p1);
        h2.getOwner().setFirstName("Xiao");
        p1.setLastName("Huang");

        p1.setGender("male");
        System.out.println(h2.getOwner().getGender());
        p1.setGender("female");
        System.out.println(p1.getGender());
        System.out.println(h2.getOwner().getGender());
        printOwnerName(h2);

        House [] houses = {h1,h2};

        for (House house : houses) {
            house.printHouseInfo(true);
        }



    }

    static void createHouses(){
    }

    static void printOwnerName(House house){
        System.out.println("Owner = " + house.getOwner().getFirstName() + " " + house.getOwner().getLastName());

    }
}
