public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isomorphic("egg","add"));
        System.out.println(isomorphic("foo","bar"));
    }

    public static boolean isomorphic(String s, String t){
        if(s.length()!= t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
