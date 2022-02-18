package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key,value;
        Node prev,next;
        Node(){};
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,Node> map = new HashMap();
    private int size, capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node temp = map.get(key);
        if(temp == null){
            return -1;
        }else{
            move2head(temp);
            return temp.value;
        }
    }

    public void put(int key, int value) {
        //get the node from hashMap
        Node temp = map.get(key);

        if(temp == null){
            //if key not exist, create new one
            temp = new Node(key,value);
            //modify HashMap
            map.put(key,temp);

            //add to head
            add2head(temp);
            size++;


            if(size > capacity){
                Node tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else{
            temp.value = value;
            move2head(temp);
        }

    }

    private void move2head(Node temp) {
        removeNode(temp);
        add2head(temp);
    }

    private void removeNode(Node temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    private void add2head(Node temp) {
        temp.prev = head;
        temp.next = head.next;
        head.next.prev = temp;
        head.next = temp;
    }
}
