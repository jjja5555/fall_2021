package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Context contextAdd = new Context(new AddOperation());
        System.out.println(contextAdd.execute(5, 15)); // Expects 20
        Context contextSubtract = new Context(new SubtractOperation());
        System.out.println(contextSubtract.execute(50, 40)); // Expects 10
        Context contextMultiply = new Context(new MultiplyOperation());
        System.out.println(contextMultiply.execute(4, 25)); // Expects 100
    }
}
