package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b-a);
    PriorityQueue<Integer> right = new PriorityQueue<>((a,b) -> a-b);
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(left.size() == right.size()){

            if (right.isEmpty() || num <= right.peek()) {
                left.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        }else{
            if(num > left.peek()){
                right.add(num);
            }else{
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek() + right.peek())/2.0;
        }else{
            return left.peek();
        }
    }
}
