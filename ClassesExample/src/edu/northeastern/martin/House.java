package edu.northeastern.martin;

public class House {

    private Person owner;
    private int houseNum;
    private String color;
    private int numOfBeds;
    private double numOfBaths;
    private boolean isSold;

    public House(int houseNum, String color, int numOfBeds, double numOfBaths) {
        this.houseNum = houseNum;
        this.color = color;
        this.numOfBeds = numOfBeds;
        this.numOfBaths = numOfBaths;
        this.isSold = isSold;
    }

    public House() {
        this.isSold = false;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public double getNumOfBaths() {
        return numOfBaths;
    }

    public void setNumOfBaths(double numOfBaths) {
        this.numOfBaths = numOfBaths;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

//    public String toString(){
//        return houseNum + " " + color;
//    }

    public void printHouseInfo(){
        System.out.println("House number = " + houseNum);
        System.out.println("Is the house sold? " + isSold);
        //System.out.println("Own name: " + owner.getFirstName() + " " +owner.getLastName()) ;
    }

    public void printHouseInfo(boolean printOwnerName){
        System.out.println("House number = " + houseNum);
        System.out.println("Is the house sold? " + isSold);
        if(printOwnerName){
            System.out.println("Own name: " + owner.getFirstName() + " " +owner.getLastName()) ;
        }
    }
}
