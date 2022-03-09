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
        TreeNode roort = new TreeNode(10,new TreeNode(5,new TreeNode(3,new TreeNode(3),new TreeNode(-2)), new TreeNode(2,null, new TreeNode(1))),new TreeNode(-3,null, new TreeNode(11)));
        System.out.println(dfs(roort,8));
    }
    static int dfs(TreeNode root, int targetSum){
        if(root == null)return 0;
        int sum = 0;
        if(targetSum == 0){
            sum++;
        }
        if(root.left != null){
            sum += dfs(root.left,targetSum-root.val);
            sum += dfs(root.left,targetSum);
        }
        if(root.right != null){
            sum += dfs(root.right,targetSum-root.val);
            sum += dfs(root.right,targetSum);
        }
        return sum;
    }
}
