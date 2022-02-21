package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};//[1,3],[2,6],[8,10],[15,18]
        int [][] out = merge(intervals);
        System.out.println();
    }


    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int[][] res = new int[intervals.length][2];
        int index = 0;
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int [] temp = intervals[i];
            if(temp[0]>right){
                res[index++] = new int[]{left,right};
                left = temp[0];
            }
            left = Math.min(left, temp[0]);
            right = Math.max(right,temp[1]);
            if( i == intervals.length-1){
                res[index++] = new int[]{left,right};
            }
        }

        return Arrays.copyOf(res,index);
    }
}
