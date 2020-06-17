
public class KLargestItem {

    /*Kth smallest -   https://www.geeksforgeeks.org/quickselect-algorithm/ */

    public static void swap(int[] arr, int i, int pivotIdx) {
        int temp = arr[i];
        arr[i] = arr[pivotIdx];
        arr[pivotIdx] = temp;
    }

    // returns the index of last partition left part
    public static int partition(int[] arr, int left, int right, int pivot) {

        int pivotValue = arr[pivot];
        int lesserValIndex = left;
        for (int i = left; i <= right; i++) {
            if (arr[i] < pivotValue) {
                // move the item rigth and increment lesser index at pivot
                swap(arr, lesserValIndex, i);
                // increment left steps
                lesserValIndex++;

            }
        }
        // why do we need to swap the lesser index?
        // I think it is because in the video they didn't choose random but choose left
        swap(arr, right, lesserValIndex);

        return lesserValIndex;
    }

    public static int quickSelect(int[] arr, int left, int right, int k) {

        int pivotIdx = left + (right - left) / 2;
        // return new pivot Idx
        pivotIdx = partition(arr, left, right, pivotIdx);
        if (pivotIdx == arr.length - k) {
            return arr[pivotIdx];
        } else if (pivotIdx < arr.length - k) {
            return quickSelect(arr, pivotIdx + 1, right, k);
        } else {
            // move left
            return quickSelect(arr, left, pivotIdx -1, k);
        }
    }

    public static void main(String[] args) {

        int[] A = {3, 2, 8, 5, 6, 4};

        System.out.println(quickSelect(A, 0, A.length - 1, 2));
        System.out.println("Remainer " + 1%10);


    }
}
