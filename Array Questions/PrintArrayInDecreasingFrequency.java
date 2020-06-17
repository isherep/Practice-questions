import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print the one which came first.
 *
 * Examples:
 *
 * Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
 *
 * Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
 *
 * Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
 *
 * Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 */
public class PrintArrayInDecreasingFrequency {

    // find the frequency of each element
    // find which element has the max frequency and print it
    // maintain new max frequency
    //  El |  Fr
    //  2    2
    //  5    2
     // 8    3
    //  6    1




    public static void printFrequencies(int[] arr){
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int key = arr[i];

            if (m.containsKey(key)) {
                int count = m.get(key);
                m.put(key, count + 1);
            } else {
                m.put(key, 1);
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> l = new ArrayList<>();
        int max = m.get(arr[0]);
        for(Map.Entry<Integer, Integer> e: m.entrySet()){
           // System.out.println(e.getKey() + ", " + e.getValue());
            l.add(e);
        }

        System.out.print("ArrayList \n");

        for(int i = 0; i< l.size(); i++){
            System.out.println(l.get(i));
        }



        /// if we get an array of values sorted - 1,2,2,3.

        // Can we look up which key has value 2?




        }
    public static void main(String[] args){
        int[] a = {2, 5, 2, 8, 5, 6, 8, 8};
        printFrequencies(a);

        // Tree Map
        // Key - frequency
        // Value - element

    }

        // now find the element with the max value
        // for each map entry
        // int max - map.entry.value;
        // if next map entry - find the max
        // print the keys of that max
        //

}
