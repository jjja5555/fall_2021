package edu.northeastern.martin;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val ){
        this.val = val;
    }
    public TreeNode(int val ,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Main {

    public static void main(String[] args) {

	// write your code here
        TreeNode root = new TreeNode(0);
        TreeNode target = new TreeNode(2);
        root.left = new TreeNode(1,new TreeNode(3),target);
        System.out.println(distanceK(root,target,1));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        //找爸爸
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        dfsFindParent(root,map);
        TreeNode cur =target;
        Set<TreeNode> visited = new HashSet<>();
        while (cur!= null){
            dfsFindK(cur,k--,list,visited);
            visited.add(cur);
            cur = map.get(cur);
        }
        return list;
    }

    private static void dfsFindK(TreeNode node, int k, List<Integer> list,Set<TreeNode> visited) {
        if(node == null || visited.contains(node)){
            return;
        }
        if(k == 0){
            list.add(node.val);
        }
        dfsFindK(node.left,k-1,list,visited);
        dfsFindK(node.right,k-1,list,visited);
    }

    private static void dfsFindParent(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        if(root == null){
            return;
        }
        if(root.left != null){
            map.put(root.left, root);
            dfsFindParent(root.left,map);
        }
        if(root.right != null){
            map.put(root.right, root);
            dfsFindParent(root.right,map);
        }
    }


}
