import java.util.PriorityQueue;

/**
 *
 * https://algorithmsandme.com/find-kth-smallest-element-in-array/
 * Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array. It is given that ll array elements are distinct.
 *
 *
 * Examples:
 *
 *
 *
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 *
 *        k = 3
 *
 * Output: 7
 *
 *
 *
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 *
 *        k = 4
 *
 * Output: 10
 *
 *
 * Building Heap runtime - O(N)
 *
 */
public class KthSmallestElement {

    public static void findKthSmallestEl(int[] arr, int k){

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i< arr.length; i++){
            // keep adding elements into heap
            heap.offer(arr[i]);
        }
        // return heap.peak()
        for(int i = 0; i < k-1; i++){  // pop up to k-1th element, and than peek the Kth
            heap.poll();
        }

        System.out.print(heap.peek());
    }

    public static void main(String[] args){
        int[] arr = {7, 10, 4, 3, 20, 15};
        findKthSmallestEl(arr, 3);


    }

    // sort the array

}
