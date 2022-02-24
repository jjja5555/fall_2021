package edu.northeastern.martin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
  }
    public static void main(String[] args) {
	// write your code here
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(5);
        String code = serialize(head);
        System.out.println(code);
        TreeNode output = deserialize(code);
        System.out.println();
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
         if(root == null)return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp != null){
                sb.append(temp.val);

                queue.add(temp.left);
                queue.add(temp.right);
            }else{
                sb.append("*");
            }
            sb.append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
         if(data == "")return null;
         String [] arr = data.split(",");
         Queue<TreeNode>  queue = new LinkedList<>();
         TreeNode res = new TreeNode(Integer.valueOf(arr[0]));
         int index =  1;
         queue.add(res);
         while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(!arr[index].equals("*")){
                TreeNode tempLeft = new TreeNode(Integer.valueOf(arr[index++]));
                temp.left = tempLeft;
                queue.add(tempLeft);
            }else{
                index++;
            }
             if(!arr[index].equals("*")){
                 TreeNode tempRight = new TreeNode(Integer.valueOf(arr[index++]));
                 temp.right = tempRight;
                 queue.add(tempRight);
             }else{
                 index++;
             }
         }
         return res;
    }

}
