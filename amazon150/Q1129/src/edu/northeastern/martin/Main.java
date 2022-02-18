package edu.northeastern.martin;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<Integer,Set<Integer>> map= new HashMap<>();
        int [][] con = {{0,1},{1,2},{2,0},{1,3},{2,4}};
        List<List<Integer>> conList = new ArrayList<>();
        for (int i = 0; i < con.length; i++) {
            conList.add(new ArrayList<Integer>());
            for (int i1 : con[i]) {
                conList.get(i).add(i1);
            }
        }


        List<List<Integer>> res = criticalConnections(5,conList);;
        System.out.println(res);
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //build Map
        Map<Integer, Set<Integer>> map = new HashMap<>();
        buildMap(connections,map);

        int [] id = new int[n];
        Arrays.fill(id,-1);

        List<List<Integer>> res = new ArrayList<>();
        dfs(0,0,-1,id,map,res);
        return res;
    }

    private static int dfs(int node, int nodeID, int parrent, int[] id, Map<Integer, Set<Integer>> map, List<List<Integer>> res) {
        id[node] = nodeID;
        Set<Integer> set = map.get(node);
        for (Integer neighbor : set) {
            if(neighbor == parrent){
                continue;
            }else if(id[neighbor] == -1){
                id[node] = Math.min(id[node],dfs(neighbor,nodeID+1,node,id,map,res));
            }else{
                id[node] = Math.min(id[node],id[neighbor]);
            }
        }
        if(id[node] == nodeID && node != 0 && parrent!= -1){
            res.add(Arrays.asList(parrent,node));
        }
        return id[node];
    }

    private static void buildMap(List<List<Integer>> connections, Map<Integer, Set<Integer>> map) {
        connections.stream().forEach(edge -> {
            //get points

            Integer n1 = edge.get(0);
            Integer n2 = edge.get(1);

            //find set of points in map, if not found make a new one
            Set<Integer> n1n = map.getOrDefault(n1,new HashSet<>());
            Set<Integer> n2n = map.getOrDefault(n2,new HashSet<>());

            //add points to set
            n1n.add(n2);
            n2n.add(n1);

            map.put(n1,n1n);
            map.put(n2,n2n);


        });
    }
}
