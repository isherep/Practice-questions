public class CheckOnlyDigits {
    /*
    0 -- 48, 9 - 57
     */
   // complexit - O(n)
    public static boolean checkIfOnlyDigits(String s){
        for(int i = 0; i< s.length(); i++){
            if((int)s.charAt(i) < 48 || (int)s.charAt(i) > 57){
                return false;
            }
        }

            return true;
    }

    public static void main(String[] args){
        String word = "103233249889";
        System.out.print(checkIfOnlyDigits(word));

    }
}
