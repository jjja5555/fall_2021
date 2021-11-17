package edu.northeastern.martin;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList(T input) {
        this.head = new Node<T>(input);
    }

    public LinkedList() {
        this.head = new Node<T>();
    }

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        return cur;
    }
    public void add2Head(T input){
        Node<T> temp = new Node<>(input);
        temp.next = head;
        head = temp;
    }

    public void reverselist(){
        if(head == null || head.next == null){
            return;
        }else{
            Node<T> cur = head;
            Node<T> temp = new Node<>(head.data);
            cur = cur.next;
            while(cur != null){
                Node<T> tempp = new Node<>(cur.data,temp);
                temp = tempp;
                cur = cur.next;
            }
            head = temp;
        }
    }

    public static Node reverselist(Node node){
        if(node == null || node.next == null){
            return node;
        }else{
            Node cur = node;
            Node temp = new Node(node.data);
            cur = cur.next;
            while(cur != null){
                Node tempp = new Node(cur.data,temp);
                temp = tempp;
                cur = cur.next;
            }
            node = temp;
            return node;
        }
    }

    public int length(){
        Node cur = head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean containCycle(){
        if(head == null || head.next == null){
            return false;
        }else{
            Node tail = head;
            Node cur = head;
            while(cur != null){
                cur =cur.next;
                if(cur == null){
                    return false;
                }
                cur = cur.next;
                tail = tail.next;

                if(cur == tail){
                    return true;
                }
            }
            return false;
        }
    }
    public Node findCycleStartNode(){
        if(head == null || head.next == null){
            return head;
        }else{
            Node tail = head;
            Node cur = head;
            while(cur != null){
                cur =cur.next;
                if(cur == null){
                    return cur;
                }
                cur = cur.next;
                tail = tail.next;

                if(cur == tail){
                    return tail;
                }
            }
            return cur;
        }
    }

    public Node getNth(int n){
        Node cur = head;
        int index = 0;
        while(cur != null){
            if(index == n){
                return cur;
            }
            index++;
            cur = cur.next;
        }
        return null;
    }

    public Node breakListInHalf(){
        if(head== null || head.next == null){
            return null;
        }
        Node cur = head;
        Node tail = head;

        //assume no cycle
        while(cur != null && cur.next != null){
            cur = cur.next.next;
            tail = tail.next;
        }
        Node secondHalf = tail.next;
        tail.next = null;
        return secondHalf;
    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        return true;
    }


}
