package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> temp = subdomamainVisits(input);
        System.out.println();
    }

    public static List<String> subdomamainVisits(String[] cpdoins) {
        Map<String,Integer> storage = new HashMap<>();
        for (String cpdoin : cpdoins) {
            String [] combination = cpdoin.split(" ");
            String number = combination[0];
            String [] domains = combination[1].split("\\.");
            String web = "";
            for (int i = domains.length-1; i >= 0 ; i--) {
                if(i == domains.length-1){
                    web = domains[i];
                }else{
                    web = domains[i] + "." + web;
                }
                if(storage.containsKey(web)){
                    storage.put(web,storage.get(web) + Integer.parseInt(number));
                }else{
                    storage.put(web,Integer.parseInt(number));
                }
            }
        }
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            output.add(entry.getValue() + " " + entry.getKey());
        }
        return output;
    }
}
