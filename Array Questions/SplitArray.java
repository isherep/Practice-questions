/**
 * Given an array of numbers, split the array into two
 * where one array contains the sum of n-1 numbers
 * and the other array with all the n-1 elements
 *
 * Problem 6 , another sample Input : {-25, 10, 15, 55, 45, 10}
 *   Output : {55} , {-25, 10, 15, 45, 10}
 *
 *   Combine 4 elements in such a way that their some is equal fifth element
 */

import java.util.Arrays;

public class SplitArray {

    // use sliding window
    // start from 0 and right and check their sum
    // check 1 and others
    // check 2 and others 4
    // check 3 and others 4
    // check 4 and others 5
    // check 5 and others 6
    // if such equal sum occurs -  return 2 arrays.

// For each element, we track it's value and other elements sum value.
    // iterate to the left
    // iterate to the right

    // Time complexity - O(n^2)

    // sort the array
    // The largest element will occur in the end.
    // If such an element exist that it's value would be a sum of 4 - it would be the largest element
    // and it would be last one.

    // sorting O(n log n)
    // Sum - N
    public static int[][] splitArray(int[] arr) throws Exception{
        // O(n log n);
       // Arrays.sort(arr);
//        for(int i = 0; i< arr.length; i++){
//            System.out.print(arr[i] + ", ");
//        }
        // find the sum of n-1 elements and increment split index
        int sumNminOneEl = 0;
       // int beforeLastIdx = arr.length -1;
       // int splitIndex ;
        for (int i = 0; i< arr.length - 1; i++){
            sumNminOneEl += arr[i];
          //  splitIndex ++;
        }
        // if such a sum exists -
        if (sumNminOneEl == arr[arr.length -1]){
            int[][] splitArrays = new int[2][arr.length -1];
            for(int i = 0; i < arr.length -1; i++){
                splitArrays[0][i] = arr[i];
            }

            splitArrays[1][0] = arr[arr.length -1];

            return splitArrays;
        } else {

            throw new Exception("The array cannot be split into two.");
        }

    }


    //2. find the sum of whole array.
    public static void spitArrays(int[] arr) throws Exception{
        if(arr == null || arr.length < 2){
            throw new IllegalArgumentException("Array must be not null and have at least 2 elements");

        }

        // find the sum of all elements in the array
        int sumNminOneEl = 0;
        // int beforeLastIdx = arr.length -1;
        // int splitIndex ;
        for (int i = 0; i< arr.length; i++){
            sumNminOneEl += arr[i];
            //  splitIndex ++;
        }

        // start substracting each element from the sum and compare leftover sum
        // to the rest of the elements
        int splitIndex = -1;
        int[] arrA = new int[1];
        int[] arrB = new int[arr.length-1];

        for(int i = 0; i< arr.length; i++){
           // calculate the sum without each element
            int leftOver = sumNminOneEl - arr[i];
            // compare the sum without each element to the each element of the array
            if (arr[i] == leftOver){
                // split array at index i
                 arrA[0] = arr[i];
                //arrB = new int[arr.length-1];
                splitIndex = i;
                break;
            }
        }

       if(splitIndex != -1){

            for(int i = 0; i< splitIndex; i++){
                arrB[i] = arr[i];
            }
            // for ( j = 6-1; j>3; j--)
            for(int j = arr.length -1; j > splitIndex; j--){
                // the other array will be one element shorter, so need to substract one from back
                arrB[j-1] = arr[j];
            }


           System.out.println("Arr A: " + Arrays.toString(arrA));
           System.out.println("Arr B: " + Arrays.toString(arrB));
        } else {
           throw new Exception("Array cannot be split in such a way");
       }




    }



    public static void main(String[] args) throws Exception{

        int[] arr = {-25, 10, 15, 55, 45, 10};
        int[] arr1 = {55, 10, 15, -25, 45, 10};

        int[] arr2 = {10, 15, -25, 45, 10, 55};
        int[] arr3 = {10};
        int[] arr4 = {4};
        int[] arrNoSplit = {-25, 10, 15, 57, 45, 10};
        int[] arr5 = {10,10};
        // int[][] result = splitArray(arr);
       // spitArrays(arr2);
       // spitArrays(arr3);
       // spitArrays(arr4);
        spitArrays(arr5);

//        for(int[] row: result){
//            System.out.println(Arrays.toString(row));
//        }
        //System.out.print(splitArray(arr).toString());
    }
}
