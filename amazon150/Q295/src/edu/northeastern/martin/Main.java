package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
    }
}
