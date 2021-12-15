package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [][]matrix = {
                {0,0,0},
                {0,0,0},
                {0,-1,0}
        };
        Roomba roomba = new Roomba(matrix);
        roomba.print();
        roomba.clean();
        System.out.println();
        roomba.print();
        System.out.println();
        roomba.turnRight();
        System.out.println(roomba.move());;
        roomba.clean();
        roomba.print();
    }
}
