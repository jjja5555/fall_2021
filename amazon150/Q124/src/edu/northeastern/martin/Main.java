package edu.northeastern.martin;
class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
   TreeNode() {}
  TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
     this.left = left;
      this.right = right;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        TreeNode test = new TreeNode(-10,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode test2 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(maxPathSum(test2));
    }

    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode node){
        int left = 0;
        int right = 0;
        if(node.left!= null){
            left = dfs(node.left);
        }
        if(node.right!= null){
            right = dfs(node.right);
        }
        int num = node.val;
        int leftMax = Math.max(num,num+left);
        int res =  Math.max(leftMax,leftMax+right);
        max = Math.max(max,res);
        if(num > num+left && num > num+right){
            return num;
        }
        return Math.max(num+left, num+right);

    }
}
