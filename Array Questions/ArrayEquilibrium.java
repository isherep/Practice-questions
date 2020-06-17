/**
 * 6
 * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes. For example, in an array A:
 * Example :
 *
 * Input : A[] = {-7, 1, 5, 2, -4, 3, 0}
 *
 * Output : 3
 *
 * 3 is an equilibrium index, because:
 *
 * A[0] + A[1] + A[2]  =  A[4] + A[5] + A[6]
 */

public class ArrayEquilibrium {

    public static int findEquilib(int[] arr){

        if(arr.length < 3){
            return -1;
        }
        int eq = -1;
        int sum = 0;
        for (int n: arr){
            sum += n;
        }
        int lSum = arr[0];
        for(int i = 1; i< arr.length; i++){
            int rSum = sum - lSum -arr[i];
            if(lSum == rSum){
                eq = i;
                break;
            }
            lSum += arr[i];
        }
        return eq;
    }

    public static void main(String[] args){
        int[] A = {-7, 1, 5, 2, -4, 3, 0};
        int[] B = {-7, 0 };
        int[] C = {-7, 1, -7};
        System.out.println(findEquilib(A));
        System.out.println(findEquilib(B));
        System.out.println(findEquilib(C));
    }
}
