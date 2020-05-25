public class MergeSortTopDownNoArrays {
    private static int[] aux; // auxiliary array for merges



    // sort(a, 0, 15)
    //  sort(a, 0, 7)
    //  sort(a, 0, 3)
    //      sort(a, 0, 1)
    //          lo, m, hi
    //  merge(a, 0, 0, 1)
    //sort(a, 2, 3)
    //merge(a, 2, 2, 3)
    //merge(a, 0, 1, 3)
    // it doesn't not break to individual components
    public static void sort(int[] a)
    {
        // create copy array with same length
        aux = new int[a.length]; // Allocate space just once.
        // apply sort method to whole array
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi)
    { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;// find middle
        sort(a, lo, mid); // Sort left half.
        sort(a, mid+1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }
   // merge 2 parts - lo to mid and mid to hi
    public static void merge(int[] a, int lo, int mid, int hi)
    { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid+1; // +1 for cases when array has 2 elements 0+1/2 = 0.5
        //  merge(a, 0, 0, 1)
        System.out.println(aux[0]);
        System.out.println();
        // compare and copy elemenets from first array at indexes.
        // Copy a[lo..hi] to aux[lo..hi].
        // Copy a[lo..hi] to aux[lo..hi].
        for (int k = lo; k <= hi; k++) // if last a[13,9] -> aux[13,9]
            aux[k] = a[k];
       // lo - beginning of first subarray, hi - beginning of second abstract subarray
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid){
                a[k] = aux[j];
                j++;
            }

            else if (j > hi) {
                a[k] = aux[i];
                i++;
            }
            else if (aux[j] < aux[i]){
                a[k] = aux[j];
                j++;

            }
            else a[k] = aux[i++];
    }
    /**
     *
     * 9,7,15,3
     *
     * 9,1      15, 3
     *
     * 9  1     12   3
     * [              ]
     *
     * [ 1,9             ]
     *
     *
     * [  1, 3 ,4, 5,9                      ]
     *    lo            mid     hi
     *   [1/,4/,9/,15]    [3/,5/,17,20]
     */

    public static void main(String[] args){
        int[] arr = {9,7,15,3};
        sort(arr);
        for(int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
