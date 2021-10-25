package edu.northeastern.martin;

public class Psychiatrist {
    //asks moody object about its mood
    public void examine(Moody moodyObject){
        System.out.println("How are you feeling today?");
        moodyObject.queryMood();
        System.out.println();
    }
    //a moodyObject is observed to either laugh or cry
    public void observe(Moody moodyObject) {
        moodyObject.ExpressFeelings();
        System.out.print("Observation: ");
        System.out.println(this.toString(moodyObject));
        System.out.println();
    }
    //returns message about self: “Subject laughs a lot”
    public String toString(Moody moodyObject){
        return moodyObject.toString();
    }
}
