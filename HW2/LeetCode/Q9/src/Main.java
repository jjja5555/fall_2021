public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(reverse("the sky is blue"));
        System.out.println(reverse("  hello world  "));
        System.out.println(reverse("a good   example"));
        System.out.println(reverse("  Bob    Loves  Alice   "));
        System.out.println(reverse("Alice does not even like bob"));
    }

    public static String reverse(String s){
        String output = "";
        String word = "";
        for (int i = 0; i < s.toCharArray().length; i++) {
            if(s.charAt(i) != 32){
                word+= s.charAt(i);
            }else if(word !=""){
                output = " "+ word+ output;
                word = "";
            }
            if(i == s.toCharArray().length-1){
                output = word+ output;
            }
        }
        return output.trim();
    }

}
