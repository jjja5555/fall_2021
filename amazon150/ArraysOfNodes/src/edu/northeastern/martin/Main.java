package edu.northeastern.martin;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int val;
    Node next;
    public Node (int val,Node next){
        this.val = val;
        this.next = next;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Node [] nodes = new Node[4];
        Node node1 = new Node(2,new Node(3,new Node(5,null)));
        Node node2 = new Node(1,new Node(2,new Node(10,null)));
        Node node3 = new Node(1,new Node(3,new Node(8,null)));
        Node node4 = new Node(-1,new Node(0,new Node(1,null)));
        nodes[0] = node1;
        nodes[1] = node2;
        nodes[2] = node3;
        nodes[3] = node4;
        Node res = addNodes(nodes);
        System.out.println();
            int [][] test = new int[][]{
                    {-2,-1,0,0},
                    {-1,0,0,1},
                    {0,0,1,2},
                    {0,1,2,3},
            };
            System.out.println(findNegative(test));
            System.out.println(findNegative2(test));
        System.out.println(findNegative3(test));

        System.out.println(canPartitionKSubsets(new int[] {4,3,2,3,5,2,1},4));
    }

    private static int findNegative3(int [][] arr){
        int n = arr.length;
        int x = 0;
        int y = arr.length-1;
        int res = 0;
        while(x < n && y>=0){
            if(arr[x][y]<0) {
                res += y+1;
                x++;
                continue;
            }else{
                y--;
                continue;
            }

        }
        return res;
    }

    private static int findNegative2(int[][] arr) {
        int res = 0;
        for (int[] ints : arr) {
            if(ints[0] >=0){
                continue;
            }
            int n = ints.length;
            if(ints[n-1] <0){
                res+= n;
                continue;
            }
            int left = 0;
            int right = n-1;
            while(left < right){
                int mid = (left+right)/2;
                int num = ints[mid];
                if(num>=0){
                    right = mid-1;
                }else{
                    left = mid;
                }
            }
            if(ints[right] <0){
                res += right+1;
            }
        }
        return res;
    }

    private static Node addNodes(Node[] nodes){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (Node node : nodes) {
            pq.add(node);
        }

        Node res = new Node(0,null);
        Node cur = res;
        while(!pq.isEmpty()){
            Node temp = pq.peek();
            cur.next = temp;
            temp = temp.next;
            pq.poll();
            if(temp!= null){
                pq.add(temp);
            }
            cur = cur.next;
        }
        return res.next;
    }

    private static int findNegative(int [][] arr){
        int res = 0;
        for (int[] ints : arr) {
            int n = ints.length;
            int rowLength = n;
            for (int i = 1; i < n; i++) {
                if(ints[i-1] >=0){
                    rowLength = 0;
                    break;
                }
                if(ints[i]>=0 && ints[i-1] <0){
                    rowLength = i;
                    break;
                }
            }
            res+= rowLength;
        }
        return res;
    }

    public static  boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum+= num;
        }
        //sum : 20
        boolean [] used = new boolean[nums.length];

        if(sum% k != 0) return false;
        int target = sum/k;
        return dfs(nums, 0,0,target,used,k);


    }

    static boolean dfs(int [] nums,int sum,int index, int target,boolean [] used,int k){
        if(sum> target)return false;
        if(sum == target){
            if(k==1)return true;
            return(dfs(nums,0,0,target,used,k-1));
        }
        for(int i = index ; i < nums.length;i++){
            if(used[i]) continue;
            int num = nums[i];
            used[i] = true;
            if(dfs(nums,sum+num,i+1,target,used,k)){
                return true;
            }
            used[i] = false;
        }
        return false;
    }


}
