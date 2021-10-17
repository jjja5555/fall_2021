public class Main {

    public static void main(String[] args) {
	// write your code here
        printArray(spiral(new int[][]{{1, 2, 3},{4,5,6},{7,8,9}}));
        printArray(spiral(new int[][]{{1, 2, 3,4},{5,6,7,8},{9,10,11,12}}));
    }

    public static int[] spiral(int[][]input){
        int [] output = new int[input.length*input[0].length];
        int top = 0;
        int bot = input.length-1;
        int left = 0;
        int right = input[0].length-1;
        int index = 0;
        while(true){
            for (int i = left; i <= right; i++) {
                output[index++] = input[top][i];
            }
            top++;
            if(top>=bot) {
                break;
            }
            for (int i = top; i <= bot; i++) {
                output[index++] = input[i][right];
            }
            right--;
            if(left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                output[index++] = input[bot][i];
            }
            bot--;
            if(top > bot){
                break;
            }
            for(int i = bot; i >= top;i--){
                output[index++] = input[i][left];
            }
            left++;
            if(left>right){
                break;
            }
        }
        return output;
    }

    public static void printArray(int [] nums){
        for (int num : nums) {
            System.out.print(num+ " ");
        }
        System.out.println();
    }
}
