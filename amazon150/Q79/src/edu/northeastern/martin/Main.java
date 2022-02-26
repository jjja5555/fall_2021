package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"EEDASFCSECBA"));
	// write your code here
    }

    private static int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] visited= new boolean[m][n];
        boolean res = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = 0;
                visited[i][j] = true;
                res =  foundWord(board,word,index,i,j,visited);
                visited[i][j] = false;
                if(res)return true;
            }
        }
        return false;
    }

    public static boolean foundWord(char[][] board,String word, int index, int x, int y, boolean [][] visited){
        if(!(word.charAt(index) == board[x][y])){
            return false;
        }
        if(index == word.length()-1){
            return true;
        }
        boolean []dirRes = new boolean[4];
        int boolIndex = 0;
        for (int[] dir : dirs) {
            int dx = x+dir[0];
            int dy = y+dir[1];
            if(dx < 0 || dy < 0 || dx == board.length||dy == board[0].length){
                continue;
            }
            if(visited[dx][dy]) continue;
            visited[dx][dy] = true;
            dirRes[boolIndex++] = foundWord(board,word,index+1,dx,dy,visited);
            visited[dx][dy] = false;
        }
        return dirRes[0] || dirRes[1] || dirRes[2] || dirRes[3];
    }
}
