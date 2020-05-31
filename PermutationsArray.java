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


    private static void permuteSwap(List<List<Integer>> result, int[] array, int start) {
        if (start >= array.length) {
            List<Integer> current = new ArrayList<Integer>();
            for (int a : array) {
                current.add(a);
            }
            result.add(current);
        } else {
            // starting at start so we only will be looking at the end of the array
            for (int i = start; i < array.length; i++) { // start =0, i = 0..2, swap with itself
                // i ended at 2
                                                        // permute(array, 0+1)new start = 1
                                                        // for(int i = 1; i< length; i++)
                                                        // swap(1, 2) start is still 1,
                                                        // permute (arr, 1+1)
                                                        // for(int i = 2; i< length; i++)
                                                        // swap(2, 2)
                                                        // now i is 3=length, so add to the list

                // last recursive call ended at i = 2, start is still 1 that was passed
                // than swapped
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
        List<List<Integer>> res =  permuteSwap(a);
        for(int i = 0; i< res.size(); i++){
            for(int j = 0; j< res.get(i).size(); j++){
                System.out.print(res.get(i).get(j) + ", ");
            }

            System.out.println();
        }

    }


}
