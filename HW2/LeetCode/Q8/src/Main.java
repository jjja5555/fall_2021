import java.util.Locale;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(palindrome("A man, a plan, a canal: Panama"));
        System.out.println(palindrome("race a car"));
    }

    public  static boolean palindrome(String s){
        String output = "";
        for (char c : s.toLowerCase().toCharArray()) {
            if(c>96 && c<122){
                output+=c;
            }
        }
        for (int i = 0; i < output.length()/2; i++) {
            if (output.charAt(i) != output.charAt(output.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
