package edu.northeastern.martin;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
	// write your code here
        TreeNode root = new TreeNode(3,new TreeNode(4,new TreeNode(1),new TreeNode(2)),new TreeNode(5));
        TreeNode subSroot = new TreeNode(4,new TreeNode(1),new TreeNode(2));
        System.out.println(isSubtree(root,subSroot));
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.val == subRoot.val){
                if(isSubtreeRecursion(temp,subRoot)){
                    return true;
                }
            }
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
        return false;
    }

    public static boolean isSubtreeRecursion(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }else{
            if(root == null || subRoot == null){
                return false;
            }
        }
        if(root.val == subRoot.val){
            return isSubtreeRecursion(root.left,subRoot.left) && isSubtreeRecursion(root.right,subRoot.right);
        }else{
            return false;
        }
    }
}
