import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        // iterate though the array sorting the strings and putting them in the map
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        // this outer loop takes O(n) time
        for(int i = 0; i< strs.length; i++){
            // initialize empty list to hold anagrams for each item
            // O(n) linear time to convert
            char[] chars = strs[i].toCharArray();
            //
            Arrays.sort(chars);
            String sorted = String.copyValueOf(chars);
            System.out.print(sorted + " ");

            if(map.containsKey(sorted)){
                // retrieve the current list value form the map key
                map.get(sorted).add(strs[i]);
            } else {
                List<String> an = new ArrayList<String>();
                an.add(strs[i]);
                map.put(sorted, an);
            }
        }

        // after you put stuff into the map - iterato through it and put values into the list

        List<List<String>> res = new ArrayList<List<String>>();

        // iterate over map

        for(List<String> list: map.values()){
            res.add(list);
        }

     return res;


    }

    public static void main(String[] args){
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);

    }
    }

