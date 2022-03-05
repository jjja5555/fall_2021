package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left,right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode head = new TreeNode(5,new TreeNode(2,new TreeNode(3),new TreeNode(9,new TreeNode(7),new TreeNode(10))),new TreeNode(4));
        leftView(head);
        rightView(head);
    }

    public static void leftView(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if(i == 0){
                    System.out.println(temp.val);
                }
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
    }

    public static void rightView (TreeNode node){
        boolean []visited = new boolean[100];
        dfsRight(node,visited,0);
    }

    private static void dfsRight(TreeNode node, boolean[]visited , int level){
        if(!visited[level]){
            System.out.println(node.val);
            visited[level] = true;
        }
        if(node.left != null){
            dfsRight(node.left,visited,level+1);
        }
        if(node.right != null){
            dfsRight(node.right,visited,level+1);
        }
    }



}
