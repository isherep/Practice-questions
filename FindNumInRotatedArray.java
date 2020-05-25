/**
 * Given a sorted array of n integers that has been rotated an unknown
 * number of times, write code to find an element in the array.
 * You may assume that the array was originally sorted in increasing order.
 * [4,5,6,7,0,1,2]
 */
public class FindNumInRotatedArray {


    public static int search(int[] arr, int key){

        return search(arr, key, 0, arr.length -1);

    }

    public static int search(int[] arr, int key, int lo, int hi){

        if(lo > hi){
            return -1;
        }

        int mid = (lo + hi)/2;

        if(arr[mid] == key){
            return mid;
        }

        System.out.println("mid " + mid);
        // if left is still sorted
        if(arr[lo] < arr[mid]) {
            // check if element is there
            if (arr[lo] <= key && key < arr[mid]) {
                return search(arr, key, lo, mid - 1);
            } else {
                return search(arr, key, mid + 1, hi);
                // if right side is sorted
            }
        } else if(arr[mid] < arr[hi]){
            if(arr[mid] < key && key <= arr[hi]){
                return  search(arr, key, mid + 1, hi);
            } else { return search(arr, key, lo, mid - 1);
            }
        } else {
            // it means that either either right or left are equal middle
            // initialize flag location -1
            int location = -1;
            if(arr[lo] == arr [mid]){
                location = search(arr, key, mid +1, hi);
            }

            if(location == -1 && arr[mid] == arr[hi]){
                location = search(arr, key, lo, mid-1);
            }

            return location;
        }

    }

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7};
        int[] arrRot = {6,7, 1,2,3,4,5};
        int[] arrRot1 = {4,5,6,7,  1,2,3};
        int[] arrRot2= {15, 16, 19, 20, 25,   1, 3, 4, 5, 7, 10, 14};

        //System.out.println("Find 7 in arr " + search(arr, 7));
        System.out.println("Find 7 in arrRot " + search(arrRot, 7));
        System.out.println("Find 5 in arrRot1 " + search(arrRot1, 5));
        System.out.println("Find 5 in arrRot2 " + search(arrRot2, 7));


    }

}
