public class ReverseNumber {


    // if we get to the point where reversed x will become
    // 2147483647, if we divide it by 10 - wll get 214748364
    // if we try to ad tge remainer that is larger than 7 :
    // 214748364 *10 + 9-  it will overflow interger.
    public int reverse(int x) {
        int result = 0;
        int res = 1;
        while(res!=0) {
            int remainer = x % 10;
            res = x / 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && remainer > 7) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && remainer < -8) {
                return 0;
            }
            result = result * 10 + remainer;
            x = res;
        }
        return result;
    }
}
