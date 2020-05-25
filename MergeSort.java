public class MergeSort {

    private static double[] merge(double[] a, double[] b) {
        double[] copy = new double[a.length + b.length];// c[ , ]  a={1}, b={}, b.lenth = 0
        int i = 0;// array a[] iterator
        int j = 0;// array b[] iterator
        for (int k = 0; k < copy.length; k++) {//a={1,3}, b={2}
            //1st iter: k=0, i=0, j=0 copy [1,0,0], a[0] =1 < b[0]=2, so 1 goes into copy
            //2nd iter: k=1, i=1, j=0, a[i]=3, b[j]=2;
            //3rd iter: k=2, i=1, j=1, a[i]=3, b[j]= null; j(1) = b.length(1)

            // case if a array ended
            if (i >= a.length){
                copy[k] = b[j];
                j++;

            }
            // case when b array ended
            else if (j >= b.length) {   // 3rd iteration - put rest of a into copy
                copy[k] = a[i];
                i++;

            }
            // if a[i] smaller - put it first in copy
            else if (a[i] <= b[j]) { // 1st iteratio here
                copy[k] = a[i];
                i++;
            }
            else {
                copy[k] = b[j]; // 2nd iter a[i]=3 > b[j]=2;
                j++;
            }

        }
        return copy;
    }

    public static double[] mergesort(double[] input) {
        int N = input.length;
        if (N <= 1) return input;

        double[] a = new double[N/2];
        double[] b = new double[N - N/2];

        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N/2];

        return merge(mergesort(a), mergesort(b));
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(double[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i-1]) return false;
        return true;
    }


}
