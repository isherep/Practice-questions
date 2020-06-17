public class ArrayProductWithoutSelf {

    public static int[] productExceptSelf(int[] nums) {

        // for each position = calculate prefix , add to result, new arrayand suffix product, add to result
        int[] result = new int[nums.length];
        int bef  = 1;
        for (int i = 0; i < nums.length; i++) {
            // result element is equal to before product and only after you increment
            result[i] = bef;
            bef *= nums[i];
        }
        int aft = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= aft;
            aft *= nums[i];
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        System.out.println("Result" + productExceptSelf(arr));
    }

}
