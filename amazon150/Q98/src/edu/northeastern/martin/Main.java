package edu.northeastern.martin;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode test = new TreeNode(2,new TreeNode(2),new TreeNode(2));
        System.out.println(isValidBST(test));
    }

    private static long pre = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if(root== null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }
}
