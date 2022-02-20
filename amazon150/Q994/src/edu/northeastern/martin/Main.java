package edu.northeastern.martin;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //
        int [][] grid = {{2,1,1},{1,1,1},{0,1,2}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[1].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int time = 0;

        while(fresh > 0 && !queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int [] orange = queue.poll();
                int row = orange[0];
                int col = orange[1];
                if(row -1 >= 0 && grid[row-1][col] ==1){
                    grid[row-1][col] =2;
                    fresh--;
                    queue.add(new int[]{row-1,col});
                }
                if(row +1 < m && grid[row+1][col] ==1){
                    grid[row+1][col] =2;
                    fresh--;
                    queue.add(new int[]{row+1,col});
                }
                if(col -1 >= 0 && grid[row][col-1] ==1){
                    grid[row][col-1] =2;
                    fresh--;
                    queue.add(new int[]{row,col-1});
                }
                if(col +1 < n && grid[row][col+1] ==1){
                    grid[row][col+1] =2;
                    fresh--;
                    queue.add(new int[]{row,col+1});
                }
            }
            time++;
        }

        if(fresh > 0){
            return -1;
        }else{
            return time;
        }
    }
}
