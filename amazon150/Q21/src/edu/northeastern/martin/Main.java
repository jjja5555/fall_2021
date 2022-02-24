package edu.northeastern.martin;

public class Main {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
	// write your code here
        ListNode node1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode node2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode node = mergeTwoLists(node1,node2);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 != null && list2 != null ){
            if(list1.val <= list2.val){
                ListNode temp = list1;
                temp.next = mergeTwoLists(list1.next,list2);
                return temp;
            }else{
                ListNode temp = list2;
                temp.next = mergeTwoLists(list1,list2.next);
                return temp;
            }
        }else{
            if(list1 == null){
                return list2;
            }else if(list2 == null){
                return list1;
            }else{
                return null;
            }
        }

    }
}
