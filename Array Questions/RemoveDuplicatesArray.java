import java.util.HashMap;

public class RemoveDuplicatesArray {

    // Ask if you need to preserve the order of elements

    // If array is unsorted
    //1.  HashMap - put element in the map, if not present - put in the new array
    // 2. Soft the array - all duplicates will be next to each other, and only put new nums

    /*
    3. Insert all array element in the Set.
     - Set does not allow duplicates and sets like LinkedHashSet maintains the order of insertion so it will remove duplicates and elements will be printed in the same order in which it is inserted.
    Convert the formed set into array.
    Print elements of Set.

    - Regular set
    - insert into set
    - if not present in the set - than insert into array
    -
    */
    public static int[] removeDuplHashMap(int[] nums){
        int[] result = new int[nums.length];

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        if(nums == null){
            return null;
        }
        if(nums.length < 1){
            return nums;
        }

        for(int i = 0; i< nums.length -1; i++){
            // if the number first seen it means it doesn't have a key
            if(!map.containsKey(nums[i])){
                result[i] = nums[i];
            }
            map.put(nums[i], true);
        }
        return result;

    }

    public static void main(String[] args){
        int[] arr = {8,8,8,5,4,4,1};

        System.out.print(removeDuplHashMap(arr));
    }
}
