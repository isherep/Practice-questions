public class LongestPalidromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        int l = s.length();
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
        for (int subl = 3; subl <= s.length(); subl++) {
            for (int i = 0; i < l - subl + 1; i++) {
                int end = i + subl - 1;
                if (s.charAt(i) == s.charAt(end) && dp[i + 1][end - 1] == 1) {
                    dp[i][end] = 1; // mark it as palidrome
                    if (subl > longestLength) {
                        start = i;
                        longestLength = subl;
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
