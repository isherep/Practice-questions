public class PerfectSquares {
    // Ask can I assume that n is positive

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // every element is min now
        for (int i = 1; i <= n; i++) {
            System.out.println("\n\ni: " + i);
            // find the squareroot of a each num 1,2,3,....n
            int sqrt = (int) Math.sqrt(i); // sqrt(2) = 1.41 = 1
            System.out.println("sqrt: " + sqrt);
            // If the number is already a perfect square,
            // then dp[number] can be 1 directly. This is
            // just a optimization for this DP solution.
//            if (sqrt * sqrt == i) { // if 1*1 != 2
//                dp[i] = 1;
//                continue;
//            }
            // To get the value of dp[n], we should choose the min
            // value from:
            //     dp[n - 1] + 1,   dp[12-1] +1
            //     dp[n - 4] + 1,   dp[12 - 4] + 1
            //     dp[n - 9] + 1,   dp[12 - 9] + 1
            //     dp[n - 16] + 1
            //     and so on...
            // for j=1, j<9
            for (int j = 1; j <= sqrt; j++) { // sqrt = 1
                System.out.print("j: " +j + ", sqrt: "+ sqrt);
                int dif = i - j * j;   //i=2 i-1*1 = 1
                System.out.println(" diff: "+dif +", "+"dp[i]: " + dp[i]);
                dp[i] = Math.min(dp[i], (dp[dif] + 1));
                System.out.println(" diff: "+dif +", "+"dp[i]: " + dp[i]);// dp[i]=
            }

            for(int iter = 0; iter<dp.length; iter++){
                System.out.print(dp[iter] + ", ");
            }
        }

        return dp[n];
    }

    public static void main(String[] args){
        System.out.print(numSquares(12));
    }
}
