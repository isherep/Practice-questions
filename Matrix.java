import java.util.LinkedList;

public class Matrix {

    static int[][] matrix = {{0,1,2,0},{3,4,5,2}, {1,3,1,5}};
    static int M = matrix.length;
    static int N = matrix[0].length;

    /**
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     *
     */

    static boolean[][] copy = new boolean[M][N];
    // create array of rows
    // first - set the colums, than set the rows
    public void setZeroes(int[][] matrix) {


        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i);
                    break;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
        // now go over the row list.
        // if the row is in this list, it means it had 0
        for (Integer integer : list) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[integer][j] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i< M; i++){
            for(int j = 0; j< N; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void printMatrix(boolean[][] matrix){
        for(int i = 0; i< M; i++){
            for(int j = 0; j< N; j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

public static void main(String[] args){
        System.out.println("Number of rows: " + M);
        System.out.println("Number of cols: " + N);

        printMatrix(matrix);
        System.out.println("\nCopy \n");
        printMatrix(copy);

       // setO(matrix);
        System.out.println("After settting to 0\n");
        printMatrix(matrix);
       System.out.println("\nAfter settting to 0\n");
        printMatrix(copy);

       // setRow(1);
      // setCol(1);
//       System.out.println("After setting row to 0\n");
//       printMatrix(matrix);







}
}
