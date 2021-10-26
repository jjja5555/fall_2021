package edu.northeastern.huang;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Projector projector = Projector.getInstance();
        Projector project1 = Projector.getInstance();
        projector.name = "proj in 401";

        System.out.println(projector.name);
        System.out.println(project1.name);
    }

}
