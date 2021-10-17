public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[]{'a'}));
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(compress(new char[]{'a','a','a','b','b','a','a'}));

    }

    public static int compress(char[] chars){
        int j = 0;
        for (int i = 0; i < chars.length;) {
            int k = i;
            while(k < chars.length && chars[i] == chars[k]){
                k++;
            }
            chars[j++] = chars[i];
            if(k-i >1){
                String num = (k-i)+ "";
                for (int y = 0; y <num.length(); y++){
                    chars[j++] = num.charAt(y);
                }
            }
            i = k;
        }
        return j;
    }
}
