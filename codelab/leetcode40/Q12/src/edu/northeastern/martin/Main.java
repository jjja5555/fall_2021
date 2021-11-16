package edu.northeastern.martin;

import java.util.HashMap;
import java.util.Map;

public class Main {
    // o : one                          one                     one             one             one (n)
    // t : two(w), three                   two, three (r)          two             two             two (w)
    // f : four (u), five               five                    five(v)
    // s : six(x), seven                seven(s)
    // e : eight(g)
    // n : nine                         nine                    nine            nine (i)
    // z : zero(z)


    // owoztneoer
    public static void main(String[] args) {
	// write your code here
        System.out.println(originalDigits("fviefuro"));
    }

    public static String originalDigits(String s) {
        Map<String,Integer> storage = new HashMap<>();
        for (char c : s.toCharArray()) {
            String initial = String.valueOf(c);
            if(!storage.containsKey(initial)){
                storage.put(initial,1);
            }else{
                storage.put(initial,storage.get(initial)+1);
            }
        }

        int[] output = new int[10];

        //zero
        while(storage.containsKey("z") && storage.get("z") != 0){
            storage.put("z",storage.get("z") -1);
            storage.put("e",storage.get("e") -1);
            storage.put("r",storage.get("r") -1);
            storage.put("o",storage.get("o") -1);
            output[0]++;
        }
        //two
        while(storage.containsKey("w") && storage.get("w") != 0){
            storage.put("t",storage.get("t") -1);
            storage.put("w",storage.get("w") -1);
            storage.put("o",storage.get("o") -1);
            output[2]++;
        }
        //four
        while(storage.containsKey("u")&& storage.get("u") != 0){
            storage.put("f",storage.get("f") -1);
            storage.put("o",storage.get("o") -1);
            storage.put("u",storage.get("u") -1);
            storage.put("r",storage.get("r") -1);
            output[4]++;
        }
        //six
        while(storage.containsKey("x") && storage.get("x") != 0){
            storage.put("s",storage.get("s") -1);
            storage.put("i",storage.get("i") -1);
            storage.put("x",storage.get("x") -1);
            output[6]++;
        }

        //eight
        while(storage.containsKey("g") && storage.get("g") != 0){
            storage.put("e",storage.get("e") -1);
            storage.put("i",storage.get("i") -1);
            storage.put("g",storage.get("g") -1);
            storage.put("h",storage.get("h") -1);
            storage.put("t",storage.get("t") -1);
            output[8]++;
        }

        //three
        while(storage.containsKey("r") && storage.get("r") != 0){
            storage.put("t",storage.get("t") -1);
            storage.put("h",storage.get("h") -1);
            storage.put("r",storage.get("r") -1);
            storage.put("e",storage.get("e") -2);
            output[3]++;
        }

        //seven
        while(storage.containsKey("s") && storage.get("s") != 0){
            storage.put("s",storage.get("s") -1);
            storage.put("e",storage.get("e") -2);
            storage.put("v",storage.get("v") -1);
            storage.put("n",storage.get("n") -1);
            output[7]++;
        }

        //five
        while(storage.containsKey("f") && storage.get("f") != 0){
            storage.put("f",storage.get("f") -1);
            storage.put("i",storage.get("i") -1);
            storage.put("v",storage.get("v") -1);
            storage.put("e",storage.get("e") -1);
            output[5]++;
        }

        //nine
        while(storage.containsKey("i") && storage.get("i") != 0){
            storage.put("n",storage.get("n") -2);
            storage.put("i",storage.get("i") -1);
            storage.put("e",storage.get("e") -1);
            output[9]++;
            if(storage.get("i") == 0 ){
                storage.remove("i");
            }
        }

        if(storage.containsKey("n")){
            output[1] = storage.get("n");
        }
        String outputStr = "";
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i]; j++) {
                outputStr+=i;
            }

        }
        return outputStr;
    }
}
