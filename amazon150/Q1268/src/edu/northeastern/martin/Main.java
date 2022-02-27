package edu.northeastern.martin;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            List <String> list = new ArrayList<>();
            for (String product : products) {
                if(product.length() <(i)){
                    continue;
                }
                if(product.substring(0,i).equals(searchWord.substring(0,i))){
                    list.add(product);
                }
                if(list.size() == 3){
                    break;
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
