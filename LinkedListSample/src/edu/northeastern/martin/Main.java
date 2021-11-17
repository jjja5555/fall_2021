package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer>  list = new LinkedList<>(1);
        list.add2Head(2);
        list.add2Head(3);
        list.add2Head(4);
        list.add2Head(5);
        //list.getTail().next = list.getHead();
        Node nth = list.getNth(1);
        System.out.println(list.containCycle());
       // Node temp = LinkedList.reverselist(list.getHead());
        //list.reverselist();
        System.out.println();
    }
}
