package edu.northeastern.martin;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode test1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(2,new ListNode(1)))));
        System.out.println(isPalindrome(test1));
    }

    static int size = 0;
    static int mid = 0;
    public static boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        mid = size/2;
        int index = 0;
        cur = head;
        ListNode pre = null;
        while(index < mid){
            ListNode temp = cur.next;
            if(cur == head){
                cur.next = null;
            }else{
                cur.next = pre;
            }
            pre = cur;
            cur = temp;
            index++;
        }
        if(size %2 == 1){
            cur = cur.next;
        }
        while(cur != null){
            if(pre.val != cur.val){
                return false;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return true;
    }
}
