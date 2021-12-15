package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int []test = {1,2,3};
        System.out.println(continuousSub(test,3));
    }

    public static int continuousSub(int [] array, int k){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int tempSum = array[i];

            if(tempSum == k){
                sum++;
            }

            for (int j = i+1; j < array.length; j++) {
                tempSum+=array[j];
                if(tempSum == k){
                    sum++;
                }
            }
        }
        return sum;
    }
    
}
