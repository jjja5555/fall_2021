public class Main {

    public static void main(String[] args) {
	// write your code here
        int [][] array1 = {{1,2,3},{4,5,6},{7,8,9}};
        print2DArray(array1);
        System.out.println();
        int [][] newArray1 = transpose(array1);
        print2DArray(newArray1);
    }

    public static int [][] transpose(int[][] input){
        if(input.length == 0 || input[0].length == 0){
            return null;
        }
        int [][] output= new int[input[0].length][input.length];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < input.length; j++) {
                output[i][j] = input[j][i];
            }
        }
        return output;
    }

    public static void print2DArray(int[][] input){
        for (int[] ints : input) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
