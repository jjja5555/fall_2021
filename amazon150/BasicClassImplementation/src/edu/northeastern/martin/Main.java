package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        Object [] objects = new Object[3];

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        System.out.println(hashSet.size());

        HashMap<Character,Integer> map = new HashMap<>();
        System.out.println(map.size());
        map.add('a',5);
        map.add('b',6);
        map.add('c',6);
        map.add('d',6);
        System.out.println(map.size());
        map.remove('d');
        System.out.println(map.size());
        System.out.println(map.get('c'));
    }
}
