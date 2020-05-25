import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Print first non repeated character from String?
 */
public class FirstNonRepeatChar {
    // returns first unique char using LinkedHashMap
    public char firstNonRepeatChar(String s){
        // put each character and its count in the map (linked)
        // iterate over map entry and print first on where count is == 1
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for( int i = 0; i< s.length(); i++){
            char current = s.charAt(i);
            if(map.containsKey(current)){
                int count = map.get(current);
                map.put(current, count + 1);
            } else {
                map.put(current, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        throw new RuntimeException("Did find any characters. Cannot return null");

    }

    public static  char firstUniqCharHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        // now iterate over stirng to find the characters in a map, since hashmap
        // does not preserve the order of insertion

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);

            }

        }
        throw new RuntimeException("No unique chars");

    }


    public static void main(String[] args){

        String word1 =  "abcdefghija";

        // b
        System.out.println(firstUniqCharHashMap(word1));


    }



}
