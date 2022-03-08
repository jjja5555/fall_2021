package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {

        Map<Character,String> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)return res;
        map.put('2',"abc");
        map.put('3',"edf");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        dfs(map,res,digits,0, new StringBuilder());
        return res;
    }

    private static void dfs(Map<Character, String> map, List<String> res, String digits, int i,StringBuilder sb) {
        if(i == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(i);
        char []chars = map.get(c).toCharArray();
        for (char aChar : chars) {
            sb.append(aChar);
            dfs(map,res,digits,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
