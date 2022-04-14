package edu.northeastern.martin;

import javafx.util.Pair;

import java.util.*;

public class Main {

    public static class Node {
        String username;
        int timestamp;
        String website;

        public Node(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }
    public static void main(String[] args) {
	// write your code her
        //["dowg","dowg","dowg"]
        //[158931262,562600350,148438945]
        //["y","loedo","y"]
        //["ldigebxndh","jxm","iit","ldigebxndh","dut","oxkr","dut","ldigebxndh","iit"]
        //[246561774,336877562,613255786,581611682,67005296,164162280,644105652,998777950,962088025]
        //["kzx","bsmy","qhmiliihh","txvn","snf","nrtj","ksakw","bsmy","txvn"]
        //["joe","joe","joe","james","james","james","james","mary","mary","mary"]
        //[1,2,3,4,5,6,7,8,9,10]
        //["home","about","career","home","cart","maps","home","home","about","career"]
        String [] username = {"ujxvud","qtn","yhe","bbihmhl","qtn","oajsd","fymccaea","zxinasv","zxinasv","gdnwegq","gdnwegq","yhe","qtn","fymccaea","bbihmhl","yhe","gdnwegq","zxinasv","duhrwymi","gdnwegq","fymccaea","jwro","duhrwymi"};
        int [] timestamp = {510569093,459267457,112819357,434015156,173224021,555971483,918575970,365450921,217850163,740216158,446647296,143162787,551924763,593948522,374975339,837290714,403268711,409065434,118509828,657659722,413124445,499502804,931643588};
        String [] website = {"dzocrfql","cmuumuqtns","cebp","nplh","y","ghvmqxwrds","ghvmqxwrds","amswicds","ghvmqxwrds","ghvmqxwrds","amswicds","cmuumuqtns","ghvmqxwrds","ghvmqxwrds","ghvmqxwrds","cmuumuqtns","qac","amswicds","qac","ghvmqxwrds","qac","y","dzocrfql"};
        System.out.println(mostVisitedPattern(username,timestamp,website));
    }

    //输入：username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"],
    // timestamp = [1,2,3,4,5,6,7,8,9,10],
    // website = ["home","about","career","home","cart","maps","home","home","about","career"]
    //输出：["home","about","career"]
    //["ujxvud","qtn","yhe","bbihmhl","qtn","oajsd","fymccaea","zxinasv","zxinasv","gdnwegq","gdnwegq","yhe","qtn","fymccaea","bbihmhl","yhe","gdnwegq","zxinasv","duhrwymi","gdnwegq","fymccaea","jwro","duhrwymi"]
    //[510569093,459267457,112819357,434015156,173224021,555971483,918575970,365450921,217850163,740216158,446647296,143162787,551924763,593948522,374975339,837290714,403268711,409065434,118509828,657659722,413124445,499502804,931643588]
    //["dzocrfql","cmuumuqtns","cebp","nplh","y","ghvmqxwrds","ghvmqxwrds","amswicds","ghvmqxwrds","ghvmqxwrds","amswicds","cmuumuqtns","ghvmqxwrds","ghvmqxwrds","ghvmqxwrds","cmuumuqtns","qac","amswicds","qac","ghvmqxwrds","qac","y","dzocrfql"]

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int len = username.length;
        List <Node> nodes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            nodes.add(new Node(username[i],timestamp[i],website[i]));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.timestamp - o2.timestamp;
            }
        });

        List<Pair<String,Set<String>>> list = new ArrayList<>();
        Map<String,Integer> lastIndex = new HashMap<>();
        for (Node node : nodes) {
            boolean contains = false;
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getKey().equals(node.website)){
                    if(!list.get(i).getValue().contains(node.username) && (lastIndex.get(node.username) == null || i > lastIndex.get(node.username))){
                        list.get(i).getValue().add(node.username);
                        contains  = true;
                        index = i;
                        break;
                    }
                }
            }
            if(!contains){
                Set<String> set = new HashSet<>();
                set.add(node.username);
                list.add(new Pair<>(node.website,set));
            }
            lastIndex.put(node.username, index == -1 ?list.size()-1:index);
        }
        int listLen = list.size();
        int sum = 1;
        List<List<String>> res = new ArrayList<>();
        Map<String,Integer> countMap = new HashMap<>();
        for (int i = 0; i < listLen; i++) {
            for (int j = i+1; j < listLen; j++) {
                for (int k = j+1; k < listLen; k++) {
                    String countMapName = list.get(i).getKey() + list.get(j).getKey() + list.get(k).getKey();
                    int count = countMap.getOrDefault(countMapName,0);
                    List <String>  temp = new ArrayList<>();
                    temp.add(list.get(i).getKey());
                    temp.add(list.get(j).getKey());
                    temp.add(list.get(k).getKey());
                    for (String s : list.get(i).getValue()) {
                        if(list.get(j).getValue().contains(s) && list.get(k).getValue().contains(s)){
                            count++;
                            countMap.put(countMapName,count);
                        }
                    }
                    if(count > sum){
                        res.clear();
                        res.add(temp);
                        sum = count;
                    }else if(count == sum){
                        res.add(temp);
                    }

                }
            }

        }
        Collections.sort(res, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int first = o1.get(0).compareTo(o2.get(0));
                if(first == 0){
                    int second = o1.get(1).compareTo(o2.get(1));
                    if(second == 0){
                        return o1.get(2).compareTo(o2.get(2));
                    }
                    return second;
                }
                return first;
            }
        });
        return res.get(0);
    }
}
