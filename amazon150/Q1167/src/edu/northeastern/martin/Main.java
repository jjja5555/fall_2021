package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class TreeNode {
    int val;
    char c;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, char c) {
        this.val = val;
        this.c = c;
        left = null;
        right = null;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here new int []{1,8,3,5}
        System.out.println(connectSticks(new int []{1,8,3,5}));

        ArrayList<String> list = new ArrayList<>();
        //Huffman
        TreeNode a= new TreeNode(45,'a');
        TreeNode b= new TreeNode(13,'b');
        TreeNode c= new TreeNode(12,'c');
        TreeNode d= new TreeNode(16,'d');
        TreeNode e= new TreeNode(9,'e');
        TreeNode f= new TreeNode(5,'f');
        PriorityQueue<TreeNode> queue = new PriorityQueue<>((o1,o2) -> o1.val -o2.val);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.add(d);
        queue.add(e);
        queue.add(f);

        while(queue.size()>1){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            TreeNode temp = new TreeNode(left.val+right.val,'*');
            temp.left = left;
            temp.right = right;
            queue.add(temp);
        }
        TreeNode res = queue.poll();
        System.out.println();
    }
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : sticks){
            pq.add(num);
        }
        int res = 0;
        while(pq.size() >1){
            int combine = pq.poll() +pq.poll();
            res+= combine;
            pq.add(combine);
        }
        return res;
    }


}
