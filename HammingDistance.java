/*
   The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    public int hammingDistance(int x, int y) {
        bin(x, sb1);
        bin(y, sb2);
        String x1 = sb1.toString();
        String y1 = sb2.toString();
        int dist = 0;
        while(x1.length() < y1.length()){
            x1 = "0" + x1;
        }
        while(y1.length() < x1.length()){
            y1 = "0" + y1;
        }
        // System.out.println(x1);
        // System.out.println(y1);
        for(int i = 0; i< x1.length(); i++){
            if(x1.charAt(i) != y1.charAt(i)){
                dist++;
            }
        }
        return dist;
    }

    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }

//        while (xor != 0) {
//            xor &= (xor - 1);
//            count++;
//        }

        return count;
    }

    public void bin(int n, StringBuilder sb){
        if (n > 1)
            bin(n/2, sb);
        sb.append(n % 2);
    }


    public int hammingDistance4(int x, int y) {
        // XORing results in 1's where there are differences,
        // and 0's on matched bits
        int c = x ^ y;

        // This will contain the number of bits which matched
        int count = 0;

        // Stop when all bits in c are 0, indicating no matches remaining to count
        // Shifting always pulls in a 0 on the most significant bit,
        // so we are always getting closer to c = 0
        while(c != 0) {
            // By bit masking with 1, we are able to check the least
            // significant bit is a 1. If it is, c & 1 = 1.
            // Otherwise, c&1 = 0.
            count += c & 1;

            // Shift the bits to the right
            // Brings in a 0 on the far left
            c = c >> 1;
        }

        // Return the number of matched bits
        return count;
    }

}
