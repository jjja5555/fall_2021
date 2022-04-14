package edu.northeastern.martin;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println(checkAttackTheOpponent(3,0,1,1));
//        System.out.println(find(20,5));
//
//        Scanner s = new Scanner(System.in);
//        String integer = s.nextLine();
//        String [] arr = integer.split(" ");
//        System.out.println(arr.length);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //System.out.println(findMaximum(list,3));


        System.out.println(ways(8,3));
    }


    public static int ways(int total, int k){
        return dfsNum(total,k,1);
    }
    static int dfsNum(int total, int k, int index){
        if(total < 0){
            return 0;
        }
        if(total == 0){
            return 1;
        }
        int sum = 0;
        for (int i = index; i <= k; i++) {
            sum += (dfsNum(total-i,k,i));
        }
        return sum;
    }

    public static String checkAttackTheOpponent(int x1, int y1, int x2,int y2){
        if(x1 == x2)return "YES";
        if(y1 == y2)return "YES";
        if((x1-y1)==(x2-y2)) return "YES";
        if((x1+y1) == (x2+y2))return "YES";
        return "NO";
    }

    public static int find(int x,int y){
        int sum = 0;
        for(int i = 1; i <= x;i++){
            int num = i;
            int intSum = 0;
            while(num!=0){
                intSum+= (num%10);
                num/=10;
            }
            if(intSum == y)sum++;
        }
        return sum;
    }

    public static int findMaximum(List<Integer> arr, int m){
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        dfs(arr,m,res,deque,0);
        int globalMax = 0;
        for(List<Integer> list : res){
            int curMin = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                int abs = Math.abs(list.get(i) - list.get(i-1));
                if(abs < curMin){
                    curMin = abs;
                }
                if(curMin > globalMax){
                    globalMax = curMin;
                }
            }
        }
        return globalMax;
    }

    static void dfs(List<Integer> arr, int m,List<List<Integer>> res,Deque<Integer> deque, int index){
        if(m == 0){
            res.add(new ArrayList<>(deque));
        }
        for (int i = index; i < arr.size(); i++) {
            deque.addLast(arr.get(i));
            dfs(arr,m-1,res,deque,i+1);
            deque.removeLast();
        }
    }


}
