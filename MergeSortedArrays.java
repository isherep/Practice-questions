public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length <1 || nums2 == null || nums2.length<1){
            return;
        }

        int n1lastIdx = nums1.length -1;

        for(int i = n-1; i >= 0 && n1lastIdx >=0; i--){
            //while(n1lastIdx >=0){
            if(nums2[i] > nums1[m-1]){
                nums1[n1lastIdx] = nums2[i];
                n1lastIdx--;

                // m--;
            } else {
                nums1[n1lastIdx] = nums1[m-1];
                nums1[m-1] = nums2[i];
                n1lastIdx--;
                m--;
            }
            //}
        }
    }

    public static void main(String[] args){
        int[] nums1 = {0};
        int[] nums2 = {1};

        //merge()
    }
}
