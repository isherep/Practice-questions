public class ValidPalidrome {
    class Solution {
        public boolean isPalindrome(String s) {
            // alpha numeric
            // if the char.tolowercase  is  a=97, z=122, 0=48,57
            s = s.toLowerCase();
            if (s.equals(null) || s.length() < 1) {
                return true;
            }
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) < 48 || (s.charAt(i) > 57 && s.charAt(i) < 97) || s.charAt(i) > 122) {
                    i++;// skip i but keep j at the same position
                } else if ((s.charAt(j) < 48 || (s.charAt(j) > 57 && s.charAt(j) < 97) || s.charAt(j) > 122)) {
                    j--;
                } else {
                    if (s.charAt(i) != s.charAt(j)) {
                        return false;
                    }
                    i++;
                    j--;
                }
            }
            return true;
        }
    }
}
