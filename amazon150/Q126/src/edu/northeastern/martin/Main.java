package edu.northeastern.martin;

import javafx.scene.layout.BorderImage;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // "hit"
        //"cog"
        //["hot","dot","dog","lot","log","cog"]
        //"qa"
        //"sq"
        //["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
        List<String> list2 = new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        List<String> list3 = new ArrayList<>(Arrays.asList("a","b","c"));
        System.out.println(findLadders("hit","cog",list));
        System.out.println(findLadders("a","c",list3));
        System.out.println(findLadders("qa","sq",list2));
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(beginWord)){
            wordList.add(beginWord);
        }
        Map<String, Set<String>> map = new HashMap<>();
        buildMap(wordList,map);
        Set<String> visited = new HashSet<>();
        //bfs
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean found = false;
        int min = 0;
        int len = 0;
        visited.add(beginWord);
        while(!queue.isEmpty()){
            int n = queue.size();
            len++;
            for (int i = 0; i < n; i++) {
                String s = queue.poll();
                Set<String> set = map.get(s);
                if(set == null)continue;
                for (String s1 : set) {
                    if(visited.contains(s1))continue;
                    visited.add(s1);
                    if(s1.equals(endWord)){
                        min = len;
                        found = true;
                        break;
                    }
                    queue.add(s1);
                }
                if(found)break;
            }
            if(found)break;
        }
        System.out.println(min);


        //dfs
        visited.clear();
        List<List<String>> res = new ArrayList<>();
        visited.add(beginWord);
        List<String>temp = new ArrayList<>();
        dfs(map,beginWord,endWord,res,temp,visited,min);
        return res;
    }



    private static void dfs(Map<String, Set<String>> map, String currentWord, String endWord, List<List<String>> res, List<String>temp,Set<String> visited,int size) {
        temp.add(currentWord);
        if(size == 0){
            if(currentWord.equals(endWord)){
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if(!map.containsKey(currentWord)){
            return;
        }
        for (String s : map.get(currentWord)) {
            if(visited.contains(s))continue;
            visited.add(s);
            dfs(map,s,endWord,res,temp,visited,size-1);
            temp.remove(temp.size()-1);
            visited.remove(s);

        }
    }

    private static void buildMap(List<String> wordList, Map<String, Set<String>> map) {
        for(String word1 : wordList){
            for(String word2 : wordList){
                if(!word1.equals(word2) && isEdge(word1,word2)){
                    Set<String> set =  map.getOrDefault(word1,new HashSet<>());
                    set.add(word2);
                    map.put(word1,set);
                }
            }
        }
    }

    private static boolean isEdge(String word1, String word2) {
        int difference = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)){
                difference++;
            }
        }
        return difference == 1 ? true : false;
    }
}
