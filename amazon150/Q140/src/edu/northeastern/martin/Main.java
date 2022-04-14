package edu.northeastern.martin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String []wordDict = {"cat","cats","and","sand","dog"};
        List<String> out = wordBreak("catsanddog",new ArrayList<>(Arrays.asList(wordDict)));
        System.out.println(out);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String s1 : wordDict) {
            set.add(s1);
        }

        Map<Integer,Set<Integer>> dpMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if(set.contains(s.substring(i,j))){
                    if(dpMap.containsKey(i)){
                        dpMap.get(i).add(j);
                    }else{
                        Set<Integer> temp = new HashSet<>();
                        temp.add(j);
                        dpMap.put(i,temp);
                    }
                }
            }
        }


        List<String> res = new ArrayList<>();
        process(0,dpMap,s,new StringBuilder(),res);

        return res;
    }

    private static void process(int index,Map<Integer,Set<Integer>> dpMap,String s,StringBuilder sb,List<String> res){
        if(index == s.length()){
            res.add(sb.toString().trim());
        }else{
            if(dpMap.containsKey(index)){
                for (Integer nextIndex : dpMap.get(index)) {
                    sb.append(s.substring(index,nextIndex)+ " ");
                    process(nextIndex,dpMap,s,sb,res);
                    sb.delete(sb.length()-(nextIndex-index+1),sb.length());
                }
            }
        }
    }

}
