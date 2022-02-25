package edu.northeastern.martin;

import java.util.*;

public class Main {

    static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    }
    public static void main(String[] args) {
	// write your code here
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isRight = true;  //true: right false: left
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null)queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
                list.add(temp.val);
            }

            if(!isRight){
                Collections.reverse(list);
            }
            res.add(list);
            isRight = !isRight;
        }
        return res;
    }
}
