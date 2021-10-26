package edu.northeastern.martin;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new LinkedList<>();
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        while(left < right || top < bottom){
            for (int i = left; i <= right; i++) {
                output.add(matrix[top][i]);
            }
            top++;
            if(top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++) {
                output.add(matrix[i][right]);
            }
            right--;
            if(right < left){
                break;
            }
            for (int i = right; i >= left ; i--) {
                output.add(matrix[bottom][i]);
            }
            bottom--;
            if(top > bottom){
                break;
            }
            for (int i = bottom; i >=top ; i--) {
                output.add(matrix[i][left]);
            }
            left++;
            if(left > right){
                break;
            }

        }
        return output;
    }
}
