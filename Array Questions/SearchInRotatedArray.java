public class SearchInRotatedArray {
    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]), [7,0,1,2,4,5,6,], find 7, mid 2, last 6
     * <p>
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     */
    public static int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);

}

    public static int helper(int[] nums, int target, int lo, int hi){
//        if(lo > hi){
//            return -1;
//        }
        while( lo < hi) {
            int mid = (lo + hi) / 2;
            System.out.println(nums[mid]);

            if (nums[mid] == target) {
                return mid;
            }
            // if the first half is softed
            if (nums[mid] > nums[lo]) {
                // if number is larger than first and sm than mid -check if the left half is softed
                if (nums[hi] >= nums[mid] && nums[mid] < target && target <= nums[hi]) {
                    return helper(nums, target, mid+1, hi);
                }
                // if number is less than mid and mid is larger than first
                if (target < nums[mid] && target >= nums[lo]) {
                    return helper(nums, target, lo, mid-1);
                }
                if (nums[mid] > nums[hi] && target <= nums[hi] && target >= nums[mid]) {
                    return helper(nums, target, mid+1, hi);
                }
            }
            // rotation is in the first half
            if (nums[mid] < nums[lo]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    return helper(nums, target, mid+1, hi);
                } else {
                    return helper(nums, target, lo, mid-1);
                }
            }
        }

        return nums[lo] == target ? lo : -1;
    };

    public static void main(String[] args){
        int[] arr = {7,0,1,2,4,5,6};
        int[] arr1 = {4,5,6,7,0,1,2};
        int[] arr2 = {0,1,2,4,5,6,7};

        System.out.println("Index the element is found: " + search(arr2, 7));
    }
}
