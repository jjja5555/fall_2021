package edu.northeastern.martin;

public class ArrayList <T>{
    private  Object [] arr;
    private int size;
    private int capacity;
    public  <T> ArrayList() {
        capacity = 2;
        size = 0;
        arr = new Object[capacity];
    }

    public T get(int i ){
        try {
            return (T) arr[i];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int size(){
        return size;
    }

    public void add(T input){
        if(size == capacity){
            capacity = capacity*2;
            Object [] temp = new Object[capacity];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[size++] = input;
    }
}
