package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Character> linkedListChar = new LinkedList<Character>();
        linkedListChar.add('a');
        linkedListChar.add('b');
        linkedListChar.add('c');
        linkedListChar.add('d');
        linkedListChar.print();

        LinkedList<String> linkedListString = new LinkedList<>();
        linkedListString.add("huang");
        linkedListString.add("huang");
        linkedListString.add("huang");
        linkedListString.print();

    }
}
