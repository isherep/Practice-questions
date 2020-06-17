/**
 * 1.
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional
 * array of numbers which has the largest sum.
 * -2 -3 |4 -1 -2 1 5| -3
 * Kadane Algorithm
 *
 */
public class LargestContinSubArray {

   // check each subarray sum and compare the the max sum
    // Time - O(n)

    // Check for subarray for the neg numbers
    // {-2}, {-2. -3}, {-2, -3, 4},
    // If there is a

     int currentMax;
     int maxAtPos;

     int start;
     int curStart;
     int end;

   // returns max subarray sum

     public static int findSumOfLargetSubArray(int[] a){
         int currentMax = a[0];
         int maxAtPos = 0;


         for(int i = 0; i< a.length; i++){
             maxAtPos = maxAtPos + a[i];

             if(maxAtPos > currentMax){
                currentMax = maxAtPos;
             }
             if(maxAtPos <0){
                 // inscrement subarray start to next element

                 maxAtPos = 0;
             }
         }
         return currentMax;
     }


    /**
     *
     * 2.
     * You are given a list of n-1 integers and these integers are in the range of 1 to n.
     * There are no duplicates in list. One of the integers is missing in the list.
     * Write an efficient code to find the missing integer.
     * @param
     * // 1,2,4,5 - n = 5 1....5, n-1 integers
     *
     */
    public static int findMisNum(int[] a){
        // find the sum of ariphmetic progression
        // find the actual sum
        // missing number = prigress sum - actual sum
        int expN = a.length + 1;
        int progSum = expN*(expN + 1)/2;

        int sum = 0;
        for (int num: a){
            sum += num;
        }

        return progSum - sum;
    }

    /**
     * 3.
     *
     * Given an unsorted array of nonnegative integers, find a continous subarray which adds
     * to a given number.
     *
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     *
     * Ouptut: Sum found between indexes 2 and 4
     *
     * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
     *
     * Ouptut: Sum found between indexes 1 and 4
     *
     * Input: arr[] = {1, 4}, sum = 0
     *
     * Output: No subarray found
     *
     * 1 + 4 + 20 + 3 = 28 - smaller, than keep adding to it
     * 1 + 4 + 20 + 3 + 10 = 38 - too large, remove one element than compare.
     *
     * 4 + 20 + 3 + 10 = 37 - still too large - remove one ele
     *
     *     20 + 3 + 10 = sum
     *
     * ---------------------------------------------
     *    let's try the {1, 6, 20, 3, 10, 5} sum = 5
     *
     *    1, 1+6 =7 -> 6 , got to i+1 -> 20  ->
     *
     *    1
     *    1+6
     *      6 - remove fist element from the sum
     *       20
     *         3
     *         3+10
     *           10
     *
     *
     *
     */

    /**
     * Write a program to sort an array of 0's,1's and 2's in ascending order.
     */
    public static void sort012s(int[] arr){
        // {2,1,2,1,1,1,1,0,0,0,2,0,2,1,0,0,0,2}
        int[] counts = new int[3];
        // fill int each count i with the counts
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i< arr.length; i++){ // arr[0] = 2 , counts[2] +1
            int cur = arr[i];
            counts[cur] ++;
        }

        count0 = counts[0];
        count1 = counts[1];
        count2 = counts[2];
        int lastIdx = 0;

        // check the counts array
        for(int c: counts){
            System.out.print(c + ", ");
        }
        System.out.println();
        // iterate over count array and fill in the previous array with counts
        for(int i = 0; i< count0; i++){
            arr[i] = 0;
            lastIdx ++;
            System.out.print(arr[i] + ", ");
        }
        // 7 + 1 i = 8 from 8th pos for cout1 steps 7 + 5 = 13
        for(int j = lastIdx; j< count0 + count1; j++){
            arr[j] = 1;
            lastIdx ++;

            System.out.print(arr[j] + ", ");
        }

        // j = 7 + 6 + 5 = 18 from 13 to 18
        for(int j = lastIdx; j<count0 + count1 + count2; j++){
            arr[j] = 2;
            System.out.print(arr[j] + ", ");
        }

    }


    /**
     * Find the subarary that adds to s. Only pos numbers
     * @param a
     * @param s
     * @return
     */
    public static int findSub(int[] a, int s){
        int sum = 0;
        int lo = 0;
        //int res = -99;
        int sum1 = a[0];
        int[] res = new int[2];

        if (sum1 == s) { //
            res[0] = 0;
            res[1] = 0;
            System.out.print("Sum found between indexes " + res[0] + " and " + res[1]);
          //  return res;
            return sum1;
        }

        for(int i = 1; i< a.length; i++) {
            if(sum1 < s) {
                sum1 += a[i];
            }
            while(sum1 > s && lo < i) {
                sum1 -= a[lo];
                lo++;
            }
            if (sum1 == s) {
                res[0] = lo;
                res[1] = i;
                System.out.print("indexes " + res[0] + res[1]);
                return sum1;
            }
        }
        System.out.print("indexes " + res[0] + res[1]);
        return sum1;
    }

    public static void main(String[] args){

//        int[] ones = {2,1,2,1,1,1,1,0,0,0,2,0,2,1,0,0,0,2};
//        sort012s(ones);

          int[] a1 = {1, 4, 20, 3, 10, 5}; //33 - assert 2, 4
          int [] arr = {1, 4, 0, 0, 3, 10, 5}; // assert 1,4
          int [] arr1 = {1, 4};
          int [] arr2 = {1};
          System.out.println("Non negative subarray sum "+ findSub(a1, 33));
          System.out.println("Non negative subarray sum "+ findSub(arr, 7));
          System.out.println("Non negative subarray sum "+ findSub(arr1, 4));
          System.out.println("Non negative subarray sum "+ findSub(arr2, 1));

//         int[] arr4 = {-2, -3, 4, -1, -2, 1, 5, -3};
//         System.out.println("Max sum is:"+ findSumOfLargetSubArray(arr4));
//
//         int[] a = {1,3,4,5,6,7,8}; // n-1 = 7, n = 8
//          //sumP = 8 * (7)/2 = 28, sum = 34
//
//
//         System.out.println("Missing number " + findMisNum(a));

    }
}
