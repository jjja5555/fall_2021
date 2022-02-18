package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Map;

public class LRUpractice {
    class Node{
        int key, value;
        Node next, prev;
        Node(){

        }
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,Node> map = new HashMap<>();
    private Node head,tail;
    private int size, capacity;

    public LRUpractice(int capacity){
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node temp = map.get(key);
        if(temp == null){
            return -1;
        }else{
            move2head(temp);
            return temp.value;
        }
    }

    public void put(int key,int value){
        Node temp = map.get(key);
        if(temp == null){
            temp = new Node(key,value);
            map.put(key,temp);
            size++;
            add2head(temp);
            if(size>capacity){
                removeTail();
                size--;
            }
        }else{
            temp.value = value;
            move2head(temp);
        }
    }

    private void move2head(Node temp) {
        deleteNode(temp);
        add2head(temp);
    }

    private void deleteNode(Node temp) {
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
    }

    private void add2head(Node temp) {
        temp.next = head.next;
        head.next.prev = temp;
        head.next = temp;
        temp.prev = head;
    }

    private void removeTail(){
        map.remove(tail.prev.key);
        deleteNode(tail.prev);
    }


}
