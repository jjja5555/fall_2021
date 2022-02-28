package edu.northeastern.martin;

class mapNode{
    Object key;
    Object value;
    mapNode next;
    public mapNode (Object key,Object value){
        this.key = key;
        this.value = value;
        next = null;
    }
    public mapNode (){
    }
}
public class HashMap <K,V>{
    private mapNode[] nodes;
    private int capacity =3;
    private int size;
    public <K,V> HashMap(){
        nodes = new mapNode [capacity];
        size = 0;
    }

    public boolean add (K key,V value){
        int index = key.hashCode()%capacity;
        if(nodes[index]  == null){
            nodes[index] = new mapNode(key,value);
        }else{
            mapNode cur = nodes[index];
            if(cur.key == key){
                return false;
            }
            while(cur.next != null){
                if(cur.key == key){
                    return false;
                }
                cur = cur.next;
            }
            cur.next = new mapNode(key,value);
        }
        size++;
        return true;
    }

    public boolean contains(K key){
        int index = key.hashCode()%capacity;
        if(nodes[index]  == null){
            return false;
        }else{
            mapNode cur = nodes[index];
            while(cur != null){
                if(key == cur.key){
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    public V get(K key){
        int index = key.hashCode()%capacity;
        if(nodes[index]  == null){
            return null;
        }else{
            mapNode cur = nodes[index];
            while(cur != null){
                if(key == cur.key){
                    return (V) cur.value;
                }
                cur = cur.next;
            }
        }
        return null;
    }

    public void remove (K key){
        int index = key.hashCode()%capacity;
        mapNode head = nodes[index];
        if(head  == null){
            return;
        }else{
            if(head.key == key){
                head = head.next;
                size--;
                return;
            }
            mapNode cur = head;
            while(cur.next != null){
                if(cur.next.key == key){
                    cur.next = cur.next.next;
                    size--;
                    return;
                }
                cur = cur.next;
            }
        }
    }


    public int size (){
        return this.size;
    }
}
