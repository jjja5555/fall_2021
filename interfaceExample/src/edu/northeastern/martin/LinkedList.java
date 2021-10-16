package edu.northeastern.martin;

public class LinkedList<T> {
    public Node head;

    public LinkedList(){
        head = null;
    }

    public  void add(T data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);

    }

    public void print(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

}
