

public class BinarySearch {

    /*
     *Assuming this is sorted array
     *
     * returns Index of the found element
     */
    public static int rank(int key, int[] arr) {
        if(arr ==null) {

            throw new NullPointerException("Input array is null");
        }

        // what happends when array is empty {}
        // lo = 0, hi - 0, mid = o/2 = 0 arr[0] = null
            return helper(key, arr, 0, arr.length - 1);


    }

    private static int helper(int key, int[] arr, int lo, int hi) {
        // Index of key in a[], if present, is not smaller than lo
       // and not larger than hi.
        // arr.length -1 will put the high index to be 0-1;
        System.out.println("Lo: " + lo + " Hi: " + hi);
    // The high index will be -1 if array is empty
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        System.out.println("Mid: " + arr[mid]);

        if (key < arr[mid]){
            return helper(key, arr, lo, mid - 1);
        }

        else if (key > arr[mid]) {
            return helper(key, arr, mid + 1, hi);
        }

        else return mid;
    }



    public static void main(String[] args){
        int[] myArr = {1,4,6,7,55,90,200};
        int[] n = null;
        int[] myEm = {};


        System.out.println("Result: " + rank(1,myArr));
      //  System.out.println("Result: " + rank(1,myArr));
       // System.out.println("Result: " + rank(200,n));
        //System.out.println("Result: " + rank(200,myEm));

    }
}
