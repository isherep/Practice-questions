/**
 * Search an element in an array where difference between adjacent elements is 1.
 *
 */
public class SearchElWhereAdjDiffisOne {

    //arr[] = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3}
    //     {e, o, e, o, e, o, e, 0, e, o, e, o}

    //  Search for 3 and Output: Found at index 7
    // If the difference is oly one, than the element can be larger or smaller by oe

    // If arr[mid] > target -> count how much it is bigger and skip that many elements.
    // check if the element is even or ad, and see if middle is even or odd.


    // looking for 3
    // middle is 5
    // can skep mid +2;


    // looking for 8 mid is 5.
    // start from mid + 1 and iterate i+2 elements to the right and left



    // 2. Start from left element
    // check if its even. If target is even too - compare i+2 starting from left
    // if left is even and target is not - compare i+2 elements starting from left +1;
    public static int search(int[] arr, int t){
        if(arr == null){
            throw new IllegalArgumentException("Array is null");
        }
        int left = arr[0];

        int res = -1;


        if(left == t){
            return 0;
        }
        // if both left and target are of the same type - go to left +=2
        if((left % 2 ==0) && (t % 2 == 0) || (left % 2 !=0) && (t % 2 != 0)){
            for(int i = 0; i< arr.length; i+=2){
                if(arr[i] == t){
                    res = i;
                    break;
                }
            }

        } else {
            for(int i = 1 ; i< arr.length; i+=2){
                if(arr[i] == t){
                    res = i;
                    break;
                }
            }

        }
        return res;
    }

    /**
     * Time Complexity - O(n), but we skip through every other element, so its more like N/2
     * Space - O(1)
     *
     * @param args
     */
    public static void main(String[] args){

        int[] arr = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3};
        int[] arr1 = {4, 3};
        int[] arrNull = null;
        //  Search for 3 and Output: Found at index 7

        System.out.println("Number 3 is found at position  " + search(arr,3));
        System.out.println("Number 4 is found at position  " + search(arr1,4));
        //System.out.println("Number 3 is found at position  " + search(arrNull,3));


    }
}
