package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRoomsFlag(intervals));

    }

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals==null||intervals.length==0) return 0;
        // 按结束时间排序
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        // 按开始时间排序
        Arrays.sort(intervals,(i,j)->i[0]-j[0]);
        queue.add(intervals[0][1]);
        for(int i=1;i!=intervals.length;i++) {
            int last=queue.peek();//最早结束的
            if(last<=intervals[i][0]) { // 最早结束的可以腾出会议室
                queue.poll();
                queue.add(intervals[i][1]); //修改该会议室的结束时间
            }else{ //最早结束的都来不及腾出会议室
                queue.add(intervals[i][1]);// 需要一个新的会议室
            }
        }
        return queue.size();
    }

    public static int minMeetingRoomsFlag(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            map.put(start,map.getOrDefault(start,0) + 1);
            map.put(end,map.getOrDefault(end,0) - 1);
        }

        int ans = 0 , sum  = 0;
        for (Integer integer : map.keySet()) {
            sum+= map.get(integer);
            ans = Math.max(sum,ans);
        }
        return ans;
    }
}
