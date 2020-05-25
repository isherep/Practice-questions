import java.util.*;
import java.util.HashSet;

public class FindDuplicateChars {
    /*
     // put the chars in a HashMap
     // Iterate and return chars whose counts are > 1


     // create a array of chars
     // for each char increment count

     Sometimes an interviewer will ask you to read a file and print all duplicate characters and their count,
     core logic will remain same, all you need to do is demonstrate how much you know about
     File IO in Java e.g. streaming file if it's very large rather than reading the whole file in memory.
     */
    public static Set<Character> findAllDuplicCharacters(String s){
        Set<Character> duplicates = new HashSet<>();
        Map<Character, Integer> counts = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char current = s.charAt(i);
            if(counts.containsKey(current)){
                // add to set at the same time
                duplicates.add(current);
                counts.put(current, counts.get(current) +1);
            } else {
                counts.put(current, 1);
            }
        }

        return duplicates;
    }

    public static void main(String[] args){
        String p = "Programming";
        Set res = findAllDuplicCharacters(p);
       Iterator<Character> it = res.iterator();
       while(it.hasNext()){
           System.out.print(it.next() + ",");
        }

    }
}
