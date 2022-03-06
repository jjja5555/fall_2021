package edu.northeastern.martin;


import java.util.HashSet;

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Node temp = new Node(3,new Node(5));
        Node temp2 = new Node(1,temp);
        temp.next.next = temp2;

        temp = insert(temp,0);
        System.out.println();
    }

    public static Node insert(Node head, int insertVal) {
        if(head == null){
            Node res = new Node(insertVal);
            res.next = res;
            return res;
        }
        Node cur = head;
        HashSet<Node> set = new HashSet<>();
        while(!set.contains(cur)){
            if(cur.next == cur){
                Node res = new Node(insertVal,cur);
                cur.next = res;
                return cur;
            }
            set.add(cur);
            if((insertVal >= cur.val && insertVal < cur.next.val) || set.contains(cur.next)){
                cur.next = new Node(insertVal,cur.next);
                break;
            }
            cur = cur.next;
        }
        return head;
    }
}
