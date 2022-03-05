package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] temp = findOrder(3,new int[][]{{1,0},{1,2},{0,1}});
        System.out.println();
        System.out.println();
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int [] inDegree = new int[numCourses];
        for(int [] prerequisite : prerequisites){
            int course  = prerequisite[0];
            int pre = prerequisite[1];
            if(!map.containsKey(pre)){
                map.put(pre,new HashSet<Integer>());
            }
            map.get(pre).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int [] res = new int[numCourses];
        int index = 0;
        while(!queue.isEmpty()){
            int pre = queue.poll();
            res[index++] = pre;
            if(map.containsKey(pre)){
                Set<Integer> set = map.get(pre);
                for(Integer course: set){
                    inDegree[course]--;
                    if(inDegree[course] == 0){
                        queue.add(course);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] >0){
                return new int[0];
            }
        }
        return res;
    }
}
