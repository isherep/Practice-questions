public class InvertImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        if(A== null || A.length<1){
            return A;
        }

        for(int i = 0; i< A.length; i++){
            int j = 0;
            int k = A[i].length-1;
            while(j < k){
                int temp = A[i][k];
                A[i][k] = A[i][j];
                A[i][j] = temp;
                j++;
                k--;
            }
        }

        for(int i = 0; i< A.length; i++){
            for(int j = 0; j< A[i].length; j++){
                if(A[i][j] == 0){
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
