package edu.northeastern.martin;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int res = maximumUnits(new int [][]{{1,3},{2,2},{3,1}},4);
        System.out.println();
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(o1, o2) -> o2[1]-o1[1]);
        int num = 0;
        int sum = 0;
        for(int [] box : boxTypes){
            if((num+box[0]) < truckSize){
                num+= box[0];
                sum+= box[0]* box[1];
            }else if(num < truckSize && num + box[0] >=truckSize){
                sum+= box[1]* (truckSize - num);
                num = truckSize;
            }
        }
        return sum;
    }
}
