/**
 * << Binary Left Shift Operator. The left operands value is moved left
 * by the number of bits specified by the right operand.
 *
 * |=|=	bitwise inclusive OR and assignment operator.
 * C |= 2 is same as C = C | 2
 *
 * | (bitwise or)	Binary OR Operator copies a bit if it exists in either operand.
 * (A | B) will give 61 which is 0011 1101, A65, B66
 *
 * https://www.youtube.com/watch?v=0AcuCP4ikrM
 *
 *
 * After we shift the bitvektor val times, it will be like
 * [0,0,0,0,........,0, 0, 0, 0, 0, 0, ]
 *      and the checker bitvector will be still all 0.
 *      Perform AND operation
 * [0,0,0,0,........,0, 1, 0, 0, 0, 0, ]
 *           Result
 * [0,0,0,0,........,0, 0, 0, 0, 0, 0 ]
 *
 *
 * 1 & 0 = 0, only 1 & 0 = 0;
 *
 * 1 | 0 = 1, 0|1 =1,
 *
 * As above the result is all 0, that means that the character was met once
 *
 * After this check - update the checker with OR operator(I'd say increment)
 *
 *
 * The checker will change it's value to have 1 whih is seen before
 *
 *    [0,0,0,0,........,0, 0, 0, 0, 0, 0, ] - checker, still 0 after & operatio
 *       Perform OR | operation   1^0 = 1
 *  * [0,0,0,0,........,0, 1, 0, 0, 0, 0, ] - current
 *  *           Result
 *  * [0,0,0,0,........,0, 1 , 0, 0, 0, 0 ]  -
 *
 */

public class IsAllUniqueCharsString {

    public static boolean isUnique(String s){
        // means some is repeated if we assume its only ASCII
        if(s.length() >128){
            return false;
        }

        boolean[] counts = new boolean[128];
        for(int i = 0; i< s.length(); i++){
            int cur = s.charAt(i);
            if(counts[cur]){
                return false;
            }
            counts[cur] = true;
        }
        return true;
    }


    /**
     * Using BITs
     *
     */

    public static boolean isUniquewBits(String s){
        int checker = 0;
        for(int i = 0; i< s.length(); i++){
            // get a character of string
            // compare checker and shifter by that char value bit vector
            // if its > 0 - than seen before
            int cur = s.charAt(i);
            if((checker & (1 << cur)) > 0){
                return false;
            }
            // now change the checker to seen before
            checker |=(1<<cur);
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "abcdepf";
       System.out.println(isUnique(s));
       System.out.println(isUniquewBits(s));
    }
}
