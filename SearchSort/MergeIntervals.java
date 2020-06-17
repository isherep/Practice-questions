
import java.util.*;

public class MergeIntervals {


    /**
     * Qyestions to ask
     *
     * Can I assume that the intervals are sorted based on their start val?
     *
     * Can I assume that each interval start < end
     * @param intervals
     */
    public static int[][] merge(int[][] intervals) {

            ArrayList<int[]> merged = new ArrayList<int[]>();

            if(intervals.length == 0 || intervals[0].length == 0)
                return intervals;

            Arrays.sort(intervals, new Comparator<int[]>(){
                public int compare(int[] a, int[] b) {
                    return a[0]-(b[0]);
                }
            });
            // adding first interval
            merged.add(intervals[0]);
            // starting at the second interval
            for(int i = 1; i < intervals.length;i++) {
                int[] current = intervals[i];
                // start adding second item from array and compare to last one in the arraylist
                int[] previous = merged.get((merged.size()-1));
                // if there is only one element - prev == current
                // if overlappint intervals
                if(current[0] <= previous[1]) {
                    // remove the last one from arraylist
                    merged.remove(merged.size()-1);
                    // make new interval from prev and select maximum end
                    int[] mergedInt = {previous[0], Math.max(previous[1],current[1])};

                    merged.add(mergedInt);//new int[] {previous[0], Math.max(previous[1],current[1])});
                }
                else {
                    // if intervals are not overlaping - just add new o
                    merged.add(current);
                }
            }

            int[][] result = merged.toArray(new int[merged.size()][]);

            return result;
        }

    public static void main(String[] args){
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};

        int[][] sample = merge(nums);

        for(int i = 0; i< sample.length; i++){
            for(int j = 0; j< sample[0].length; j++){
                System.out.print(sample[i][j] + "  ");
            }
        }

    }
}
