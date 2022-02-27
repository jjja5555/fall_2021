package edu.northeastern.martin;

public class MinStack {

    class Node {
        int val;
        Node next;
        public Node(){

        }
        public Node(int val ){
            this.val = val;
            this.next = null;
        }
    }
    private Node min;
    private Node head;

    public MinStack() {
            head = null;
            min = null;
    }

    public void push(int val) {
            if(head == null){
                head = new Node(val);
                min = new Node(val);
            }else{
                Node temp = new Node(val);
                temp.next = head;
                head = temp;
                if(temp.val <= min.val){
                    Node minTemp = new Node(val);
                    minTemp.next = min;
                    min = minTemp;
                }
            }
    }

    public void pop() {
        if(head.val == min.val){
            min = min.next;
        }
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min.val;
    }
}
