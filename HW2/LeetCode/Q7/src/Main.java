public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(addStrings("11","123"));
        System.out.println(addStrings("456","77"));
        System.out.println(addStrings("0","0"));

    }

    public static String addStrings(String num1, String num2){
        int i = num1.length()-1;
        int j = num2.length()-1;
        int add = 0;
        String output = "";
        while(i>=0 || j>=0 || add != 0){
            int x = 0;
            int y = 0;
            if(i >=0){
                x = num1.charAt(i)-'0';
            }
            if(j >= 0){
                y = num2.charAt(j) - '0';
            }
            int result = x+y+add;
            add = result/10;
            output = result%10+output;
            i--;
            j--;
        }
        return output;
    }
}
