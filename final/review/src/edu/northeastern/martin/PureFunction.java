package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.List;

public class PureFunction {
    public int add(int a,int b){
        return a+b;
    }
    public static void main(String[] args) {
        // write your code here
        PureFunction pure = new PureFunction();
        System.out.println(pure.add(1,2));
    }
}
