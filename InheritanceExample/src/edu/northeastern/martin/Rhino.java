package edu.northeastern.martin;

public class Rhino extends Animal{

    public Rhino() {

    }

    public Rhino(String hx, int i, double v) {
        super(hx,i,v);
        type = AnimalType.mamal;
    }

    public void eat(){
        System.out.println("I am a Rhino, give me leafy things to eat");
    }

}
