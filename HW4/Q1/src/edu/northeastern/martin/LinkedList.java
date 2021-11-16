package edu.northeastern.martin;

class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    public Node() {

    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }


}

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList(int value) {
        this.head = new Node(value);
        this.size = 1;
    }

    public synchronized void addAtPosition(int index, int element){
        if(index > this.size){
            System.out.println("index out of bound");
        }else{
            if(index == 0){
                Node temp = head;
                head = new Node(element,temp);
                size++;
            }else{
                Node cur = head;
                for (int i = 0; i < index-1; i++) {
                    cur = cur.next;
                }
                if(index == size){
                    cur.next = new Node(element);
                }else{
                    Node temp = cur.next;
                    cur.next = new Node(element,temp);
                }
                size++;

            }
        }

    }

    public synchronized void removeAtPosition(int index){
        if(index > this.size-1){
            System.out.println("index out of bound");
        }else{
            if(index == 0){
                head = head.next;
                size--;
            }else{
                Node cur = head;
                for (int i = 0; i < index-1; i++) {
                    cur = cur.next;
                }

                if(cur.next.next != null){
                    cur.next = cur.next.next;
                }else{
                    cur.next = null;
                }
                size--;

            }
        }
    }
    public synchronized int getFirst() {
        return head.value;
    }

    public synchronized int getLast() {
        Node cur = head;
        while(cur.next!= null){
            cur = cur.next;
        }
        return cur.value;
    }

    public synchronized int size(){
        return this.size;
    }
}
