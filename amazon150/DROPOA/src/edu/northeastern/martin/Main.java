package edu.northeastern.martin;

import java.util.ArrayDeque;
import java.util.Deque;

class State{
    int cursor;
    int start;
    int end;
    String cache;

    public State(int cursor, int start, int end, String cache) {
        this.cursor = cursor;
        this.start = start;
        this.end = end;
        this.cache = cache;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        String [][] input = new String[][]{{"APPEND","Hello, world!"},{"SELECT","7","12"},{"BACKSPACE"},{"MOVE","6"},{"UNDO"},{"UNDO"},{"REDO"},{"REDO"}};
        String [] test = solution(input);
        System.out.println();
    }

    public static String [] solution(String [][] input){
        int n = input.length;
        StringBuilder sb = new StringBuilder();
        int cursor = 0;
        String [] res = new String[input.length];
        int [] select =  null;
        String clipboard = null;
        Deque<State> undoDeque = new ArrayDeque<>();
        Deque<State> redoDeque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String instruction = input[i][0];
            if(instruction.equals("APPEND")){
                String value = input[i][1];
                if(select != null){
                    undoDeque.push(new State(cursor,select[0],select[1],sb.toString()));
                    sb.delete(select[0],select[1]);
                    sb.insert(select[0],value);
                    select = null;
                }else{
                    undoDeque.push(new State(cursor,-1,-1,sb.toString()));
                    sb.insert(cursor,value);
                }
                cursor+= value.length();
            }else if(instruction.equals("MOVE")){
                if(select != null){
                    select = null;
                }
                String value = input[i][1];
                cursor = Integer.valueOf(value);
            }else if(instruction.equals("BACKSPACE")){
                if(select != null){
                    undoDeque.push(new State(cursor,select[0],select[1],sb.toString()));
                    sb.delete(select[0],select[1]);
                    select = null;
                }else{
                    if(cursor> 0){
                        undoDeque.push(new State(cursor,-1,-1,sb.toString()));
                        sb.deleteCharAt(0);
                        cursor--;
                    }
                }
            }else if(instruction.equals("SELECT")){
                int left = Integer.valueOf(input[i][1]);
                int right = Integer.valueOf(input[i][2]);
                select = new int[]{left,right};
            }else if(instruction.equals("COPY")){
                if(select != null) {
                    clipboard = sb.substring(select[0],select[1]);
                }
            }else if(instruction.equals("PASTE")){
                if(clipboard != null) {
                    if(select != null){
                        sb.delete(select[0],select[1]);
                    }
                    String value = clipboard;
                    if(select != null){
                        sb.insert(select[0],value);
                        select = null;
                    }else{
                        sb.insert(cursor,value);
                    }
                    cursor+= value.length();
                }

            }else if(instruction.equals("UNDO")){
                if(select!= null){
                    redoDeque.push(new State(cursor,select[0],select[1],sb.toString()));
                }else{
                    redoDeque.push(new State(cursor,-1,-1,sb.toString()));
                }
                State temp = undoDeque.poll();
                if(temp != null){
                    sb.setLength(0);
                    sb.append(temp.cache);
                    cursor = temp.cursor;
                    if(temp.start >0 && temp.end>0){
                        select = new int[]{temp.start,temp.end};
                    }else{
                        select = null;
                    }
                }

            }else if(instruction.equals("REDO")){
                if(select!= null){
                    undoDeque.push(new State(cursor,select[0],select[1],sb.toString()));
                }else{
                    undoDeque.push(new State(cursor,-1,-1,sb.toString()));
                }
                State temp = redoDeque.poll();
                sb.setLength(0);
                sb.append(temp.cache);
                if(temp != null){
                    sb.setLength(0);
                    sb.append(temp.cache);
                    cursor = temp.cursor;
                    if(temp.start >0 && temp.end>0){
                        select = new int[]{temp.start,temp.end};
                    }else{
                        select = null;
                    }
                }
            }
            res[i] = sb.toString();
        }
        return res;
    }
}
