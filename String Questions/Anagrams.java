import static java.lang.Character.valueOf;

public class Anagrams {
    /*
  Check if the word is an anagram of another word

  1. Sort strings and see if they are equal
      Time O(n log n) for sorting

  2. Check if every character of first string is present in the second string and
     second string has nothing left besides them
 */

    /*
       Time complexity is O(M*N^2)
     */
    public static boolean checkIfAnagram(String word1, String word2) {
        // for each character in word 1:
        // find the index of that character in the word2
        // if index not found - already not an anagram
        // if character is found - cut the word 2 into 2 substrings without that char
        // continue the same thing.

        if (word1.length() != word2.length()) {
            return false;
        }
        boolean isAnagram = true;

        for (int i = 0; i < word1.length(); i++) {  // O(n)
            char c = word1.charAt(i);
            int index = word2.indexOf(c);    // (O(m)
            if (index != -1) {
                // string builder has better perfomance
                //In the StringBuilder case, the amortized complexity of N calls
                // to sb.append(s) for strings of size Mis O(M*N)
                word2 = word2.substring(0, index) + word2.substring(index + 1);
            } else {
                return false;
            }
        }

        return word2.isEmpty();
    }

    /**
     * Most efficient way - use counting hashtable
     * If we can assume that strings contain only alphabet characters
     */

    public static boolean isAnagramHashTable(String word1, String word2) {
        // create an array of corresponding characters
        int[] characters = new int[26];
        // iterate over first word - put 1's in the char spot
        // iterate over second word - substract 1's in the char spot
        // if all the array elements are 0 - than its an anagram
        for (int i = 0; i < word1.length(); i++) {
            int charIdex = valueOf(word1.charAt(i));
            characters[charIdex]++;
        }

        for (int i = 0; i < word2.length(); i++) {
            characters[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

    }

}
