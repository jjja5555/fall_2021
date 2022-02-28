package edu.northeastern.martin;

public class HashSet <T>{
    Node[] nodes;
    int capacity =3;
    int size;
    public <T> HashSet(){
        nodes = new Node [capacity];
        size = 0;
    }

    public boolean add (T input){
        int index = input.hashCode()%capacity;
        if(nodes[index]  == null){
            nodes[index] = new Node(input);
        }else{
            Node cur = nodes[index];
            if(cur.val == input){
                return false;
            }
            while(cur.next != null){
                if(cur.val == input){
                    return false;
                }
                cur = cur.next;
            }
            cur.next = new Node(input);
        }
        size++;
        return true;
    }

    public boolean contains(T input){
        int index = input.hashCode()%capacity;
        if(nodes[index]  == null){
            return false;
        }else{
            Node cur = nodes[index];
            while(cur != null){
                if(input == cur.val){
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    public int size (){
        return this.size;
    }
}
