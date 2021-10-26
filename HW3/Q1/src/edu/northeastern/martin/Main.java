package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // write your code here
        Sad sad = new Sad();
        Happy happy = new Happy();
        Psychiatrist psy = new Psychiatrist();
        psy.examine(happy);
        psy.observe(happy);
        psy.examine(sad);
        psy.observe(sad);
    }
}
