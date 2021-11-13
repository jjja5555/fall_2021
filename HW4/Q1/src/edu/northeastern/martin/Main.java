package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList linkedList = new LinkedList(1);
        linkedList.addAtPosition(1,2);
        linkedList.addAtPosition(1,0);
        linkedList.addAtPosition(3,5);
        linkedList.addAtPosition(0,0);
        linkedList.removeAtPosition(0);
        linkedList.removeAtPosition(4);
        linkedList.removeAtPosition(2);
        System.out.println("size is: " + linkedList.size());
        System.out.println("first element is: " + linkedList.getFirst());
        System.out.println("last element is: " + linkedList.getLast());
    }
}
