package edu.northeastern.martin;

public class Cat extends Animal{
    public Cat(){

    }
    public Cat(String name, int age, double weight) {
        super(name, age, weight);
    }

    public void breathe(){
        System.out.println("miaomiaomiao");
    }
}
