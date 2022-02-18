package edu.northeastern.martin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        reorderLogFiles(logs);
        System.out.println();
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a,b) -> {
            String [] aSplit = a.split(" ",2);
            String [] bSplit = b.split(" ",2);
            if(!Character.isDigit(aSplit[1].charAt(0)) && Character.isDigit(bSplit[1].charAt(0))){
                return -1;
            }
            if(Character.isDigit(aSplit[1].charAt(0)) && !Character.isDigit(bSplit[1].charAt(0))){
                return 1;
            }
            if(Character.isDigit(aSplit[1].charAt(0)) && Character.isDigit(bSplit[1].charAt(0))){
                return 0;
            }
            if(!Character.isDigit(aSplit[1].charAt(0)) && !Character.isDigit(bSplit[1].charAt(0))){
                if(aSplit[1].equals(bSplit[1])){
                    return aSplit[0].compareTo(bSplit[0]);
                }else{
                    return aSplit[1].compareTo(bSplit[1]);
                }
            }
            return 0;
        });
        return logs;
    }

    public static String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

}
