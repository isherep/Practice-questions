import java.util.Random;

public class QuickSelectKthLargest {
    int [] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // kth largest is (N - k)th smallest 1st largest is 4th smallest
        return quickselect(0, size - 1, size - k);
    }
    /*
     3. 2 1 5 6 4  p=3
    move to end
    4 2 1 5 6 3   k smallest = 0, at i=1, store_idx =0, a[i] < pivot 2<3, so swap 2 and 4, store idex becomes 1, i = 1
    2 4 1 5 6 3   store_idx =1
    // at i =2, will do that swap with the store idex 1, because arr[i]1 < 3
    2 1 4 5 6 3
    // than put the 3 where it belogs
    2 1 3 5 6 3  // keep looping, no other elements are less than 3, return store idx
    // now k_smallest is at pos 2 which = 3
     */
    public int partition(int left, int right, int pivot_index) {

        int pivot = this.nums[pivot_index];
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right); // {3,9,7,5,1}

        return store_index;
    }

    public int quickselect(int left, int right, int k_smallest) {
    /*
    Returns the k-th smallest element of list within left..right.

    */
        if (left == right) // If the list contains only one element,
            return this.nums[left];  // return that element

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);
        // return new pivot after partition where all the elements on a left
        // are larger than pivot and all elements
        pivot_index = partition(left, right, pivot_index);

        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
            return this.nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index) // quickselect(0, size - 1, size - k);(0,5,3)\
            // ex, looking for 4th largest
            // piv_idx will be 2 at first iteration, 2<4 - so go to righ side
            return quickselect(left, pivot_index - 1, k_smallest);//{5,6,4}
        // go right side
        return quickselect(pivot_index + 1, right, k_smallest);
    }


    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }


    public static void main(String[] args){

        int[] arr = {5,1,7,3,9};

        QuickSelectKthLargest mySelect = new QuickSelectKthLargest();

        System.out.println(mySelect.findKthLargest(arr,2)); // 7

    }




}
