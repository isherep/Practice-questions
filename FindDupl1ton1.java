public class FindDupl1ton1 {
    /**
     * Given an array that contains numbers from 1 to n-1 and exactly 1 duplicate, find that duplicate.
     *
     * If the array has all numbers in order, than it is ariphmetic progression with coeficient 1
     *
     * The sum of ariphmetic progression is n*(n-1)/2
     *
     * Works only with positive numbers
     *
     * To find duplicate or mising numner - find the difference between the AP sum and actual sum.
     *
     * @param
     */

    public static int findDupl(int[] arr){
        // find the sum of all numbers in the array
        int sum = 0;

        for(int i = 0; i< arr.length; i++){
           sum += arr[i];
        }
        int n = arr.length;

        return sum - (n * (n-1)/2);

    }


//    public static int findMissing(int[] arr){
//        int sum = 0;
//        int n = arr.length-1;
//
//    }

    public static void main(String[] args){
        int[] arr = { -9, -8, 2, 6, 1, 8, 5, 3, 4, 7 };
        System.out.println("Duplicate: " + findDupl(arr));


    }
}
