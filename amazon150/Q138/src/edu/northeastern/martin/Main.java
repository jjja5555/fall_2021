package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
	// write your code here
        //7 13 11 10 1
        Node one = new Node(7);
        Node two = new Node(13);
        Node three = new Node(11);
        Node four = new Node(10);
        Node five = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        one.random = null;
        two.random = one;
        three.random = five;
        four.random = three;
        five.random = one;
        Node copy = copyRandomList2(one);
        System.out.println();
    }

    public static Node copyRandomList(Node head) {
        Map<Integer, Node> map= new HashMap<>();
        Node newNode = new Node(head.val);
        map.put(head.val,newNode);

        //two pointers to loop
        Node current = head;
        Node newCur = newNode;

        //loop
        while(current != null){
            if(current.next!= null){
                if(map.containsKey(current.next.val)){
                    newCur.next = map.get(current.next.val);
                }else{
                    Node temp = new Node(current.next.val);
                    newCur.next = temp;
                    map.put(temp.val,temp);
                }
            }
            if(current.random != null){
                if(map.containsKey(current.random.val)){
                    newCur.random = map.get(current.random.val);
                }else{
                    Node temp = new Node(current.random.val);
                    newCur.random = temp;
                    map.put(temp.val,temp);
                }
            }

            //update pointers
            current = current.next;
            newCur = newCur.next;
        }

        return newNode;
    }

    public static Node copyRandomList2(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}
