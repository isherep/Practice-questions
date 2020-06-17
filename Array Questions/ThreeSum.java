import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    // Questions to ask:

    // 1. Are all the numbers unique? - makes problem easy. It's not
    // 2. Can our output have duplicates? or what constitutes duplicate?
// ex: {0,0,0,0,0} - are first 3 0's different form other 3 0

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length - 1; i++){
            int comp = 0 - nums[i];
            int l = i+1;
            // for each i except first - check if it's not the same as prefvois
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //System.out.print("Nums length " + nums.length);
            int r = nums.length -1;
            while(l < r){
                if(nums[l] + nums[r] == comp){
                    List<Integer> curL = new ArrayList();
                    curL.add(nums[i]);
                    curL.add(nums[l]);
                    curL.add(nums[r]);

                    res.add(curL);
                    l++;
                    r--;

                    while ( r > l && nums[l] == nums[l-1]){
                        // move to next left
                        l++;
                    }

                    while(r > l && nums[r] == nums[r+1]){
                        r--;
                    }
                } else if(nums[l] + nums[r] > comp){
                    r--;

                } else {
                    l++;
                }

            }
        }
        return res;
    }
}
