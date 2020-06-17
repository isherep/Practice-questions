/**
 * Find the element that appears once in a sorted array where all other elements
 * appear twice one after another. Find that element in 0(logn) complexity.
 * Input:   arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
 *          if all the elements are repeated than the first occurance will be at
 *          even index and repeated element will be at odd index.
 *
 * Output:  4
 */
public class FindElThatAppearsOnceInSorted {


        public static int singleNonDuplicate(int[] nums) throws Exception{
            return singleNonDuplicateHelper(nums, 0, nums.length -1);
        }

        private  static int singleNonDuplicateHelper (int[] nums, int lo, int hi)throws Exception{
            // int lo = 0;
            // int hi = nums.length -1;
            // base case

            if (nums.length %2 != 0) {


                if (lo == hi) {
                    return nums[lo];
                }

                int mid = lo + (hi - lo) / 2;

                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid + 1]) {
                        // look right at mid+2
                        return singleNonDuplicateHelper(nums, mid + 2, hi);
                    } else {
                        // look at the let
                        return singleNonDuplicateHelper(nums, lo, mid);
                    }
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        // look on the right
                        return singleNonDuplicateHelper(nums, mid + 1, hi);
                    } else {
                        return singleNonDuplicateHelper(nums, lo, mid - 1);
                    }
                }
            } else {
                throw new Exception("The array doesn't have a qunique non rep chacacte");
            }
        }

      public static void main(String[] args) throws Exception{

            int[] a ={ 1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8};
            int[] b ={ 1, 1, 3, 3};

            System.out.print(singleNonDuplicate(a));
          System.out.print(singleNonDuplicate(b));

      }
    }


// all the elements if they are double, first element starts at even index
    // and repeat element is odd index
    //Assuming that uniqueu element does exist
    // find middle
    // if the middle index is odd  - compare with mid-1:
    // if mid == mid-1 -->-> look right  singleNonDuplc(nums, mid + 1, hi)
    // else(ex. 3 != 2) -->-> look left singleNonDepl(nums, lo, mid -1)

    // [1,1,2] - mid = 1  odd
    //.     mid == mid-1 - look right [2] (nums, 2, 2)
    // case low == high:
    // if the middle index is even - compare wtih mid + 1
    //     if(nums[mid] == nums[mid + 1]){
    // look to the right
    //  if(nums[mid]) != num[mid + 1]{
    //          // look to the left
    //}
    //}
    //
    // if low == high:
    //       that means it is single element left an its unique


