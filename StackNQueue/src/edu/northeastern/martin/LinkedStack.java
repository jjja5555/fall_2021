package edu.northeastern.martin;

public class LinkedStack <T>{
    private Node<T> head;

    private int size = 0;
    public LinkedStack(){
        head = null;
    }

    public void push (T data){
        Node temp = new Node(data);
        temp.next = head;
        this.size++;
        head = temp;
    }

    public T pop(){
        if(head == null){
            return null;
        }

        T temp = head.data;
        head = head.next;
        return temp;
    }

    public T peek(){
        if(head == null){
            return null;
        }
        return head.data;
    }

    public int size (){
        return this.size;
    }

    public boolean isEmpty(){
        return head== null;
    }

}
