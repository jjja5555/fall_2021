public class Main {

    public static void main(String[] args) {
	// write your code here
        printArray(moveZeros(new int[]{0,1,0,3,12}));
        printArray(moveZeros(new int[]{0}));
        printArray(moveZeros(new int[]{0,0,5,0,1}));
        printArray(moveZeros(new int[]{1,2,3,0,5,0}));
    }

    public static int[] moveZeros(int [] input){
        for (int i = 0; i < input.length; i++) {
            if(input[i] == 0){
                for (int j = i+1; j < input.length; j++) {
                    if(input[j] != 0){
                        input[i] = input[j];
                        input[j] = 0;
                        break;
                    }

                }
            }
        }
        return input;
    }

    public static void printArray(int[] nums){
        for (int value : moveZeros(nums)) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
