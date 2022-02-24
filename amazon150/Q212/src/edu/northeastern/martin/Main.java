package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        char [][] board = {{'a','b','c','e'},{'x','x','c','d'},{'x','x','b','a'}};
        char [][] board2 = {{'a','b'},{'c','d'}};
        char [][] board3 = {{'a','a'}};
        String [] words = {"oath","pea","eat","rain"};
        String [] words2 = {"abcd"};
        //System.out.println(findWords(board,words));
        //System.out.println(findWords(board2,words2));
        System.out.println(findWords(board,new String[]{"abc","abcd"}));

    }


    static int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public static List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        boolean [][] visited;
        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited = new boolean[m][n];
                    if(dfs(i,j,board,0,word,visited)){
                        found = true;
                        break;
                    }
                }
                if(found){
                    break;
                }

            }
            if(found){
                res.add(word);
            }
        }
        return res;
    }

    private static boolean dfs(int i, int j,char [][]board,int index,String word,boolean [][] visited) {
        if(board[i][j] != word.charAt(index)){
            return false;
        }
        if(index == word.length() -1){
            return true;
        }
        visited[i][j] = true;
        index++;
        boolean [] result = new boolean[4];
        int resultIndex = 0;
        for (int[] dir : dirs) {
            int dx = i+dir[0],dy = j+dir[1];
            if(dx < 0 || dx> board.length-1 || dy <0 || dy > board[0].length-1){
                continue;
            }
            if(visited[dx][dy]){
                continue;
            }
            visited[dx][dy] = true;
            boolean temp = dfs(dx,dy,board,index,word,visited);
            result[resultIndex++] = temp;
            visited[dx][dy] = temp;
        }
        return result[0] || result[1] || result[2] || result[3];
    }
}
