package edu.northeastern.martin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] out = prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0},1000000000);
        System.out.println();
    }

    public static int[] prisonAfterNDays(int[] cells, int n) {
        int [] old = cells;
        int len = cells.length;
        int loop = 0;
        for (int i = 0; i < n; i++) {
            int []temp = new int[len];
            for (int j = 1; j < len-1; j++) {
                if((cells[j-1] == 1 && cells[j+1] == 1) ||(cells[j-1] == 0 && cells[j+1] == 0)){
                    temp[j] = 1;
                }
            }
            cells = temp;
            if(i == 50){
                old = cells;
            }
            if(Arrays.equals(cells,old)){
                loop = i-50;
                break;
            }
        }
        System.out.println(loop);
        return cells;
    }
}
