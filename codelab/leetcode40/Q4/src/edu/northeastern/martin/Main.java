package edu.northeastern.martin;


import java.util.List;

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
        //1 -> 4 -> 5
        ListNode a = new ListNode(-2,new ListNode(1,new ListNode(4,new ListNode(5))));

        //1 -> 3 -> 4
        ListNode b = new ListNode(-2,new ListNode(5,new ListNode(6)));

        //2 -> 6
        ListNode c = new ListNode(-2,new ListNode(0));
        ListNode[] lists = {a,b,c};
        ListNode[] test = {};
        printLinkList(mergeKLists(lists));
        //printLinkList(mergeKLists(new ListNode[]{new ListNode(1), new ListNode(0)}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        boolean hasNodes = true;
        ListNode head = null;
        ListNode tail = null;
        while(hasNodes){
            int counts =0;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] == null){
                    counts++;
                    continue;
                }
                int val = lists[i].val;
                if(head == null){
                    head = new ListNode(val);
                    tail = head;
                }else if(val < head.val){
                    ListNode current = new ListNode(val,head);
                    head = current;
                }else if(val >= tail.val){
                    ListNode current = new ListNode(lists[i].val);
                    tail.next = current;
                    tail = current;
                }else{
                    ListNode current = head;
                    while(current.next != null){
                        if(current.next.val > val){
                            ListNode temp = current.next;
                            current.next = new ListNode(val,temp);
                            break;
                        }
                        current = current.next;
                    }
                }

                lists[i] = lists[i].next;


            }
            if(counts == lists.length){
                hasNodes = false;
            }

        }
        return head;
    }

    static void printLinkList(ListNode node){
        if(node != null){
            System.out.print(node.val + " -> ");
            printLinkList(node.next);
        }else{
            System.out.println();
        }
    }
}
