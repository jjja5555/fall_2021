package edu.northeastern.martin;

public class Main {

    private static boolean [][] passed;
    public static void main(String[] args) {
	// write your code here
        char [][] map = {{'1','1','0','0','0'},
                         {'1','1','0','1','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}
        };
        System.out.println(numIslands(map));
     }

    //brute force
    public static int numIslands(char[][] grid) {
        int num = 0;
        passed = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(passed[i][j]){
                    passed[i][j] = true;
                    continue;
                }
                if(grid[i][j] == '1'){
                    num++;
                    recursion(grid,i,j);
                }
            }
        }
        return num;
    }

    private static void recursion(char[][] grid, int i, int j){
        passed[i][j] = true;
        if(i != 0 && !passed[i-1][j] && grid[i-1][j] == '1'){
            recursion(grid,i-1,j);
        }
        if(i != grid.length-1 && !passed[i+1][j] && grid[i+1][j] == '1'){
            recursion(grid,i+1,j);
        }
        if(j != 0 && !passed[i][j-1] && grid[i][j-1] == '1'){
            recursion(grid,i,j-1);
        }
        if(j != grid[0].length-1 && !passed[i][j+1] && grid[i][j+1] == '1'){
            recursion(grid,i,j+1);
        }
    }
}
