package edu.northeastern.martin;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> list = new ArrayList<>();
        Arrays.asList(list);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(dfsFoundKid(p,q)){
            return p;
        }

        if(dfsFoundKid(q,p)){
            return q;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean foundP= false;
        boolean foundQ = false;
        Map<TreeNode,TreeNode> map = new HashMap<>();
        while(!queue.isEmpty() && !(foundP && foundQ)){

            TreeNode temp = queue.poll();
            if(temp == p){
                foundP = true;
            }
            if(temp == q){
                foundQ = true;
            }
            if(temp.left != null){
                map.put(temp.left,temp);
                queue.add(temp.left);
            }
            if(temp.right != null){
                map.put(temp.right,temp);
                queue.add(temp.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        boolean foundParent = false;
        set.add(p);
        set.add(q);
        TreeNode pCur = p;
        TreeNode qCur = q;
        while(!foundParent){
            TreeNode tempP  = map.get(pCur);
            if(tempP != null && !set.add(tempP)){
                return tempP;
            }
            TreeNode tempQ  = map.get(qCur);
            if(tempQ != null && !set.add(tempQ)){
                return tempQ;
            }
            pCur = tempP;
            qCur = tempQ;

        }
        return null;
    }

    private static boolean dfsFoundKid(TreeNode p, TreeNode q) {
        if(p == null){
            return false;
        }

        if (p == q) {
            return true;
        }

        return dfsFoundKid(p.left,q) || dfsFoundKid(p.right,q);
    }
}
