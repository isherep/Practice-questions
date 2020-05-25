public class FindNumOnVowAndConsonants {
      /*
        How to count Vowels and Consonants in Java String Word
     */

    public int[] findVowConson(String s) {
        int[] holder = new int[2];

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int numVal = (int) cur;
            if ((numVal >= 65 && numVal <= 90) || (numVal >= 97 && numVal <= 122)) {
                // check if vowel = 65, 69, 73,
                if (cur == 'a' || cur == 'o' || cur == 'e' || cur == 'u') {
                    // ccadd the same but capital
                    holder[1]++;
                } else {
                    holder[2]++;
                }

            }


        }

        // crate an arrays of vow and another wiht consonants
        // check check if string character with each array character
        // O(N^2)
        // First check if the character is in the ASCII range for con or vowels
        // if true
        // // check if string char is one of the ascii numbers for vowels
        // if its not - than its a consonant
        // upper cases - 65 - 90 inclusive
        // lower cases - 97-122

        return holder;
    }
}
