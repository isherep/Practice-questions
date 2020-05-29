import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsArray {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private static void backtrack(int[] nums, int start, List<Integer> cur, List<List<Integer>> res) {
        // in the beginning the cur list will be empty - new list
        if (cur.size() == nums.length) {
            // if current list filled up - add it to the array
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i <= cur.size(); i++) {
            cur.add(i, nums[start]);
            System.out.println("i " + i + ", start: " + start + ", nums[start] " + nums[start]);
            backtrack(nums, start + 1, cur, res);
            cur.remove(i);
            System.out.println("removed i " + i);
        }
    }


    public static List<List<Integer>> permuteSwap(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteSwap(result, num, 0);
        return result;
    }

    /*
    https://www.youtube.com/watch?v=IPWmrjE1_MU

    res = {[1,2,3], [1,3,2]

      [1,2,3] - first iteration swaps wiht itself
      [1,3,2] - second iteration , i=2, start =1,
                than i=2, start=2 - swap with itself, not doing anything.


      starting array [1,3,2] start = 2, i=2, not do anything, swap with itself, than call
      permutation again and at this point i==length, so it will just add the array to res
     At that point i=3, start =1, break out that lop and come back.
     Than that swap will put it back to 123

     Now i =1,
    Start =1, a=[2,1,3], that start =1, thatn start =2
    start reaches length so ad to result

     increment i
    than increment i - [2,3,1]



AT THE END OF EACH ITERATION WE ARE COMMING BACK TO THE STARTING ARRAY


     */

    private static void permuteSwap(List<List<Integer>> result, int[] array, int start) {
        if (start >= array.length) {
            List<Integer> current = new ArrayList<Integer>();
            for (int a : array) {
                current.add(a);
            }
            result.add(current);
        } else {
            // starting at start so we only will be looking at the end of the array
            for (int i = start; i < array.length; i++) {
                System.out.println("Start: " + start + ", i: " + i);
                swap(array, start, i);
                permuteSwap(result, array, start + 1);
                System.out.println(" ");
                // backtracking to previous array order
                swap(array, start, i);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        //permute(a);
        permuteSwap(a);

    }


}
