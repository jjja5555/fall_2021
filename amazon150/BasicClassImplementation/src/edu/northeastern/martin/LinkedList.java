package edu.northeastern.martin;

class Node{
    Object val;
    Node next;
    public Node (Object val){
        this.val = val;
        next = null;
    }
    public Node (){
    }
}
public class LinkedList <T>{


    Node head;
    int size;
    public <T>LinkedList() {
        size = 0;
    }

    public T get(int index ){
        int i = 0;
        Node cur = head;
        while(cur != null && index > i){
            i++;
            cur = cur.next;
        }
        if(cur == null){
            try {
                return (T) cur.val;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void add(T input){
        if(size == 0){
            head  = new Node(input);
            size++;
            return;
        }
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = new Node(input);
        size++;
    }
}
