import java.util.Arrays;

public class RemoveDuplicates {
    // assuming the array is sorted
    // if not sorted - sort
    public static int[] removeDupls(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.sort(arr);
        // copy a number to an array only if it is not a duplicate
        // copy first number
        // go to second, if i+1 == i - skip
        // need the first number to go into new array
        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result[i] = arr[i];
            }
        }
        return result;
    }

    public static int[] removeDuplIndex(int[] arr) {
        int[] res = new int[arr.length];
        int index = 0;
        for (int num : arr) {
            if ( java.util.Arrays.asList(arr).indexOf(num) == -1)
                res[index++] = num;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 4, 5};
        int[] a1 = {1, 2, 1, 1, 1, 1, 1};

        System.out.print(Arrays.toString(removeDupls(a1)));

    }
}
