package edu.northeastern.martin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Path{
    int vertex;
    double rate;
    Path(int vertex, double rate){
        this.vertex = vertex;
        this.rate = rate;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        System.out.println(s.maxProbability(3,new int[][]{{0,1},{1,2},{0,2}},new double[]{0.5,0.5,0.2},0,2));
    }

}
