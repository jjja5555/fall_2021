package edu.northeastern.martin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    double res = 0.0;
    boolean [] visited;
    int start;
    int end;
    Map<Integer, Set<Path>> map = new HashMap<>();
    double[] rates;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        rates = succProb;
        this.start = start;
        this.end = end;
        visited = new boolean[n];
        for(int i = 0 ; i < n;i++){
            map.put(i, new HashSet<Path>());
        }
        Path startPath;
        for(int i= 0; i < n;i++){
            int one = edges[i][0];
            int two = edges[i][1];
            double rate = succProb[i];
            map.get(one).add(new Path(two,rate));
            map.get(two).add(new Path(one,rate));
        }
        dfs(new Path(start,1),1);
        return this.res;
    }

    private void dfs(Path path,double lastRate){
        visited[path.vertex] = true;
        if(path.vertex == end){
            res = Math.max(res,lastRate);
            visited[path.vertex] = false;
            return;
        }
        Set<Path> set = map.get(path.vertex);
        for(Path p : set){
            if(visited[p.vertex])continue;
            dfs(p,p.rate* lastRate);
        }
    }
}
