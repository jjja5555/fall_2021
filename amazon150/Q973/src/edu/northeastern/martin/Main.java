package edu.northeastern.martin;

import java.util.*;

public class Main {

    private static Random rand = new Random();
    public static void main(String[] args) {
	// write your code here
        int[][] points = {{5,-1},{3,3},{-2,4},{-3,-3}};

        //map
        int[][] res = kClosest(points,2);

        //sort
        //res = kClosestSort(points,2);

        //quick sort
        res = kClosestQuickSort(points,2);
        System.out.println();
    }



    //map
    public static int[][] kClosest(int[][] points, int k) {

        //key: length, value index concat
        Map<Integer,List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            int [] p = points[i];
            int distance = p[0]* p[0]+p[1]*p[1];
            List list = map.getOrDefault(distance, new ArrayList<Integer>());
            list.add(i);
            map.put(distance,list);
        }
        int [][]res = new int[k][2];
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            for (Integer integer : integerListEntry.getValue()) {
                res[index] = points[integer];
                index++;
                if(index == k){
                    return res;
                }
            }
        }
        return null;
    }

    //sort
    public static int[][] kClosestSort(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0] + o1[1]*o1[1] - o2[0]*o2[0] - o2[1]*o2[1] ;
            }
        });
        return Arrays.copyOfRange(points,0,k);
    }

    public static int[][] kClosestQuickSort(int[][] points, int k) {
        int n = points.length;
        random_select(points,0,n-1,k);
        return Arrays.copyOfRange(points,0,k);
    }

    private static void random_select(int[][] points, int left, int right, int k) {
        int pivotId = left + rand.nextInt(right - left +1);
        int pivot = points[pivotId][0]*points[pivotId][0] + points[pivotId][1]*points[pivotId][1];
        swap(points,right,pivotId);

        int i = left -1;
        for(int j = left;j < right; j++){
            int distance = points[j][0]*points[j][0] + points[j][1]*points[j][1];
            if(distance <= pivot){
                i++;
                swap(points,i,j);
            }
        }
        i++;
        swap(points,i,right);
        if(k < i - left +1){
            random_select(points,left,i-1,k);
        }else if(k > i - left +1){
            random_select(points,i + 1,right,k-(i-left+1));
        }
    }

    private static void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
