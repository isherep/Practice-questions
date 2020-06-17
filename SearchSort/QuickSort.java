public class QuickSort {

    private static void swap (int[] arr, int i, int j){
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /**
     *
     * @param arr
     * @param pivotIdx middle element
     * @return The index where all the elements before it are smaller and all the elements after are
     * larger
     */
    public static int partition (int[] arr, int left, int right, int pivotIdx){
        int pivotVal = arr[pivotIdx]; //2
        int lowerBorder = left;
        for(int i = left; i < right; i++){
           //  {5,3,[7],1,9,10}; i = 0, LB = 0
            // [5,3,[1],7*,9,10 i=2; LB = 2
            // i = 3, do not swap
            // i = 4
            // [5,3,[1]lb,7P,9i,10
           if(arr[i] < pivotVal) {
               swap(arr, lowerBorder, i);
               lowerBorder++;
           }
        }
        // now we need to put pivot after lowerbound ends
        swap(arr,pivotIdx,lowerBorder);
        return lowerBorder;
    }

    public static void quickSort(int[] arr, int start, int end){
        // choose pivot as a middle
        int pivotIdx = start + (end - start)/2;
        int lowerIdx = partition(arr, start, end, pivotIdx);
        quickSort(arr, start, lowerIdx-1);
        quickSort(arr, lowerIdx +1, end);
    }

    public static void main(String[] args){
        int[] arr = {5,3,7,1,9,4};
        quickSort(arr, 0, arr.length -1);
       // System.out.print(Arrays.toString(arr));
    }
}
