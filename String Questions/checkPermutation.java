/**
 * Check if one is permutation of other
 */
public class checkPermutation {
    /*Using the array to count characters*/
    public static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int[] counts = new int[128];

        for(int i = 0; i< s1.length(); i++){
            int cur = s1.charAt(i) - 'a';
            // check if array contains it's character
            counts[cur] ++;
        }

        for(int j = 0; j< s2.length(); j++){
            int cur = s2.charAt(j) - 'a';
            if(counts[cur] < 1){
                return false;
            }
            counts[cur] --;
        }
        return true;
    }

    public static void main(String[] args){
        String s1 = "dog";
        String s2 = "gol";

        System.out.print(isPermutation(s1, s2));
    }
}
