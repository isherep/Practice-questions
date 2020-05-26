import java.util.List;
import java.util.Set;

public class MaximumLengthOfConcatString {
    public int maxLength(List<String> arr) {
        // find all strubgs who's elemenets do not repeat.

        // Create a set seen
        // record the length of current string and put all characters in the set
        // go to the next string
        // check if every character is not in set yet - ad to the length
        // if the character is in set - continue;
        // do the same for the next i
        // j=i+1;

        Set<Character> set = new java.util.HashSet<>();
        int len = 0;
        int maxL = 0;
        for (int i = 0; i < arr.size(); i++) {
            // first check if the string has all unique characters in it
            String cur= arr.get(i);
            // continue to next iteration if string contains duplicates
            if(!isCharsUnique(cur)){
                continue;
            }

            for(int j = 0; j < arr.size(); j++) {

                String curj = arr.get(j);
                boolean flag = false;

                // check if the set contains the chars from the word
                //empty the set when moving to next iteration
                boolean broken = false;

                for (char c : curj.toCharArray()) {
                    if (set.contains(c)) { // skip this substring all together
                        broken = true;
                        break; // or continue


                    } else {
                        // add to the set, incremement the length
                        set.add(c);
                        len++;
                    }
                }
                // if we did skip the word because ther was a duplicate -
                // than get that word's length and if the total length is
                // larger with this word than with previous - use this length;

                // after that compare lengths and select largerone
                if (broken) {
//                len += arr.get(j).length();
//                maxL= Math.max(len, maxL);
                    len = Math.max(len, len + curj.length());
                }
                if (maxL == 26) {
                    return maxL;
                }
            }

            //set.clear();
        }

        return len;
    }

    public static boolean isCharsUnique(String s){
        int checker = 0;

        for(int i = 0; i< s.length(); i++){
            int val = s.charAt(i) -'a';
            if((checker &(1<<val)) > 0){
                return false;
            }

            checker |= 1 << val;
        }

        return true;
    }

    public static void main(String[] args){

    }



}

/*
class Solution {

    public int maxLength(List<String> arr) {

        int total= 1 << arr.size(), max_len= 0;

        for(int i = 0; i < total; i++) {

            HashSet<Character> set= new HashSet<>();
            int curr_len= 0;

            for(int j = 0; j < arr.size(); j++) {

                boolean flag= false;

                if((i & (1 << j)) > 0) {

                    if(curr_len + arr.get(j).length() > 26)
                        continue;

                    for(int k = 0; k < arr.get(j).length(); k++) {

                        if(set.contains(arr.get(j).charAt(k))) {
                            flag= true;
                            break;
                        }
                        set.add(arr.get(j).charAt(k));

                    }

                    if(!flag) {
                        curr_len += arr.get(j).length();
                        max_len= Math.max(curr_len, max_len);
                    }
                    if(max_len == 26)
                        return max_len;
                }

            }
        }

        return max_len;
    }
}



 */



/*
I used recursive method and backtracking to stop adding a new word which has duplicate characters with the result. (The result will be stored as a HashSet)
After that, we can simply return the size of HashSet.

Let's say input array is {abc, def, ghi, jkl}.
n is the length o input and m is the size of word.
Recursive method is called n times and won't be repeated by using a hashset checking if any character of a new word already exists in the hashset.

So, we make n time recursive method calls at most and the each recursive method is going to chech character of a new word.
Timce complexity is O(nm) and Space complexity is O(nm + n) because we could end up storing all unique characters of input and method stack call will be n.
So, TC: O(nm) and SC: (nm)

public int maxLength(List<String> arr) {
    int maxLength = 0;
    for(int i = 0; i < arr.size(); i++){
        HashSet<Character> hs = new HashSet<Character>();
        maxLength = Math.max(maxLength, getMaxLength(arr, hs, i));
    }

    return maxLength;
}

public int getMaxLength(List<String> arr, HashSet<Character> hs, int index){
    if (index == arr.size())
        return hs.size();
    for(char c : arr.get(index).toCharArray()){
        if (hs.contains(c))
            return getMaxLength(arr, hs, index + 1);
    }

    HashSet<Character> temp = new HashSet<Character>();
    for(char c : arr.get(index).toCharArray()){
        if (temp.contains(c))
            return getMaxLength(arr, hs, index + 1);
        temp.add(c);
    }
    hs.addAll(temp);
    int maxLength = hs.size();
    for(int i = index + 1; i < arr.size(); i++){
        maxLength = Math.max(maxLength, getMaxLength(arr, new HashSet<Character>(hs), i));
    }

    return maxLength;
}
 */
