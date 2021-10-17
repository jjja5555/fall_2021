public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println("1D");
//        print2D(new int [][] {{1}});
//        print2D(rotate90(new int [][] {{1}}));
//        System.out.println();
//        System.out.println("2D");
//        print2D(new int [][] {{1,2},{3,4}});
//        System.out.println();
//        print2D(rotate90(new int [][] {{1,2},{3,4}}));
//        System.out.println();

        System.out.println("3D");
        print2D(new int [][] {{1,2,3},{4,5,6},{7,8,9}});
        System.out.println();
        print2D(rotate90(new int [][] {{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println();

        System.out.println("4D");
        print2D(new int [][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
        System.out.println();
        print2D(rotate90(new int [][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
        System.out.println();

        System.out.println("5D");
        print2D(new int [][] {{1,2,3,4,5},{6,7,8,9,10},{10,11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
        System.out.println();
        print2D(rotate90(new int [][] {{1,2,3,4,5},{6,7,8,9,10},{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24}}));
        System.out.println();
    }

    public static int[][] rotate90(int[][]matrix){
        if(matrix.length == 1){
            return matrix;
        }
        //rotate
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < (matrix.length+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-j][i];
                matrix[matrix.length-1-j][i] = matrix[matrix.length-1-i][matrix.length-1-j];
                matrix[matrix.length-1-i][matrix.length-1-j] = matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i] = temp;
            }

        }
        return matrix;
    }

    public static void print2D(int[][] matrix){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
