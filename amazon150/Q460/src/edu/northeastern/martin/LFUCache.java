package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Map;

class FrequencyList{
    Node head = new Node();
    Node tail = new Node();
    FrequencyList(){
        head.next = tail;
        tail.pre = head;
    }
}
class Node {
    int key;
    int val;
    Node next;
    Node pre;
    int count = 0;
    Node(){}
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
public class LFUCache {
    int capacity;
    Map<Integer, Node> map  = new HashMap<>();
    Map<Integer, FrequencyList> freq = new HashMap<>();
    int minFreq = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            updateFreqList(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if(this.capacity == 0)return;
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            updateFreqList(node);
        }else{
            if(map.size() == capacity){
                FrequencyList frequencyList = freq.get(minFreq);
                Node node = frequencyList.tail.pre;
                map.remove(node.key);
                deleteNode(node);
            }
            Node temp = new Node(key,value);
            map.put(key,temp);
            updateFreqList(temp);
            minFreq = 1;
        }
    }

    private void updateFreqList(Node node) {
        if(node.next != null && node.pre != null){
            deleteNode(node);
            FrequencyList last = freq.get(node.count);
            if(last.head.next == last.tail && node.count == minFreq){
                minFreq++;
            }
        }
        node.count++;
        FrequencyList freqList;
        if(!freq.containsKey(node.count)) {
            freqList = new FrequencyList();
            freq.put(node.count,freqList);
        }else{
            freqList = freq.get(node.count);
        }
        add2Head(node,freqList);
    }

    private void add2Head(Node temp, FrequencyList frequencyList) {
        Node head = frequencyList.head;
        temp.next = head.next;
        temp.pre = head;
        head.next.pre = temp;
        head.next = temp;
    }


    private void deleteNode(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
}
