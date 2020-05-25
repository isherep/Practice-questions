/**
 * A magic index in an array A[0…n-1] is defined to be
 * an index such that A[i] = i.
 * Given a sorted array of distinct integers,
 * write a method to find a magic index if one exists,
 * in an array A.
 * FOLLOW UP: What if the values are not distinct?
 */
public class MagicIndex {


    // mid = lo + hi/2
    // if (arr[i] == i){
   // return i;

   // If we take a middle and it's value < i - than look right
   //arr[3] < 3  search mid+1, hi
    // If we take a middle and it's value > i - than look left.

    // If array is sorted,
      // if arr[mid] = i {
// return mid;

public static int getMagicIndex(int[] arr, int lo, int hi){

    int mid = (hi + lo)/2;

//    if(arr[mid] == mid){
//        return mid;
//    }
if(lo < hi) {
    if (arr[mid] < mid) {
        return getMagicIndex(arr, mid + 1, arr.length - 1);
    } else if (arr[mid] > mid) {
        return getMagicIndex(arr, 0, mid);
    } else {
        return mid;
    }
}

 return -1;


}

   // return getMagicIndex(arr, 0, arr.length - 1);


    /**
     * Best time -O(1)
     * Worse time - 0(logn)
     * @param args
     */


    // Follow up - hwat if the values are not unique,
    // but array is still sorted
    // int[] arr = {-3, -3, -3, 0, 1, 1, 1, 7};
    // look over each element

    // look for xor of arr[i] and i - same as look for arr[i] == i
    //

//
public static void main(String[] args){
    int[] arr = {-3, -2, -1, 0, 4};
    int[] arr1 = {0,1,2,3, 4};
    int[] arr2 = {-7, 1, -2, 8, 9};

    System.out.println("MI " + getMagicIndex(arr,0, arr.length-1));
    System.out.println("MI " + getMagicIndex(arr1,0, arr.length-1));
    System.out.println("MI " + getMagicIndex(arr2,0, arr.length-1));


}
}
