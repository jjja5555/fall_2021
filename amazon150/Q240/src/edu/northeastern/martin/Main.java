package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while(x < m && y >=0){
            if(matrix[x][y] == target){
                return true;
            }
            if(matrix[x][y] > target){
                y--;
            }else{
                x++;
            }
        }
        return false;
    }
}
