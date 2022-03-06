package edu.northeastern.martin;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode input = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,new ListNode(6))))));
        ListNode temp = oddEvenList(input);
        System.out.println();
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode cur = head;
        ListNode even = new ListNode();
        ListNode evenCur = even;
        while(cur != null){
            evenCur.next = cur.next;
            if(cur.next == null || cur.next.next == null){
                cur.next = even.next;
                break;
            }else{
                cur.next = cur.next.next;
            }
            cur = cur.next;
            evenCur = evenCur.next;
        }

        return head;
    }
}
