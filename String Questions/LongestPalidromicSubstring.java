/**
 * This is for SUBSEQUENCE NOT SUBSTRING !!!!!
 *
 * 2 conditions:
 *  - start == end
 *  - middle substring inside is a palidrome too.
 */
public class LongestPalidromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        int l = s.length();
        // initialize all palidrome for letter with itself to 1
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }
        // there has to be different case when the substring is 2
        int start = 0;
        int longestLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = i;
                longestLength = 2;
            }
        }
        // keep expanding the k - size of possible palidrome
        for (int k = 3; k <= s.length(); k++) {
            for (int i = 0; i < l - k + 1; i++) {
                int end = i + k - 1;
                // check if last and first eleent match at ith position
                // if they - look up if the one inside them before them was a palidrome
                if (s.charAt(i) == s.charAt(end) && dp[i + 1][end - 1] == 1) {
                    dp[i][end] = 1; // mark it as palidrome
                    if (k > longestLength) {
                        start = i;
                        longestLength = k;
                    }
                }
            }
        }
        // check the filled table
        //System.out.println();
        // for(int i = 0; i< l; i++){
        //     for(int j = 0; j<l; j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }
        return s.substring(start, start + longestLength);
    }

}
