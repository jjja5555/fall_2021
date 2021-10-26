package edu.northeastern.huang;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashMap<Integer,String> map = new HashMap<>();
        map.put(5,"huang");

        Projector proj1 = Projector.getProjector(1);
        Projector proj2 = Projector.getProjector(2);
        System.out.println(proj1.getProjectorId());
        System.out.println(proj2.getProjectorId());
        proj2 = Projector.getProjector(1);
        System.out.println(proj2.getProjectorId());
        System.out.println(Projector.getProjector(2).getProjectorId());

    }
}
