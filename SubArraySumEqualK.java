/*
4. Given an unsorted array of integers, find a subarray which adds to a given number. If there are more than one subarrays with sum as the given number, print any of them.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33

Ouptut: Sum found between indexes 2 and 4



Input: arr[] = {10, 2, -2, -20, 10}, sum = -10

Ouptut: Sum found between indexes 0 to 3



Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20

Ouptut: No subarray with given sum exists


// sort - 1,3,4,5,10,20,3 - nlog n at minimum

// HashMap -

// if in any previous map key, there is such a partner element that (key + cur sum) == equal

// while sum < target - keep adding numbers
// if it becomes larger than target - remove number
// store each sum in the map and the index where this sum was
1+4 = 5
1+4+20 = 25 <33
1+4+20+3 = 28 <33
1+4+20+3+10 = 38 >33 - than find if any previous subsum is equal to cur_sum-target.
1+4+20+3+10+5 = 42>33 - look for 42-33 = 9
1+4+20+3+10+5+33 = 75>33 - look for 75 - 33 =42


numOfArrays++;


what if array is
arr[] = {1, 4, 20, 3, 10, 5, 33}, sum = 33
/

[1,1,1]

Map:
S   i
1 = 0
//2 = 1
 =


k-sum = 1 - present
Now I need to get another k-sum=1, so I need another subsum that is one


What if there will be another sum-k somewhere, that we will loose first one
So we before we ad the current sum-k, we need to retrieve it's count if it's there
and increment it.

Why put 0 in the map?  map.put(0, 1);

Because there's might be the situation where one element whose sum equals to k.
In that case, we need to get the key 0 in the map.
If we don't put (0, 1) to the map, we will not find that key

So the partner will be sum-k ==> 33 - 33 = 0;

*/


import java.util.HashMap;

public class SubArraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum-k);
            }
            // if map doesn't have this prefix sum -put count 1 in there
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                // if it does - get it count, increment and put back
                map.put(sum, map.get(sum) + 1);
            }
        }
        return count;
    }

}
