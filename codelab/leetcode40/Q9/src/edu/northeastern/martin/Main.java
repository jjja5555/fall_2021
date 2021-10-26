package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] test = {{1,4},{2,3}};
        int[][] output = merge(intervals);
        System.out.println();
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(v1, v2) -> v1[0] - v2[0]);
        int tail = intervals.length-1;
        for (int i = intervals.length-1; i >0 ; i--) {
            if(intervals[i][0]<=intervals[i-1][1] && intervals[i-1][1]<intervals[i][1]){
                intervals[i-1][1] = intervals[i][1];
                intervals[i] = null;
            }else if(intervals[i][0] <= intervals[i-1][0] && intervals[i][1] >= intervals[i-1][1]){
                intervals[i-1] = intervals[i];
                intervals[i] = null;
            }else if(intervals[i-1][0] <= intervals[i][0] && intervals[i-1][1] >= intervals[i][1]){
                intervals[i] = null;
            }
        }
        List<int[]> list = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if(interval != null){
                list.add(interval);
            }
        }
        return list.toArray(new int[0][]);
    }
}
