public class PalidromePermutation {

    public static boolean isPalidromePermutation(String s){
        // if the characters are a to z - generate array of size z-a;
        int[] counts = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1 ];
        int[] a = new int['z'-'a'+1];
        // get the count of each character
        for(int i =0; i< s.length(); i++){

            counts[(s.charAt(i)) - 'a'] ++;
        }
        // go over the count array and find if countOdd is >=1;
        int countOdd = 0;
        for(int i = 0; i< counts.length; i++){
            if(countOdd > 1){
                return false;
            }
            if(counts[i] % 2 !=0){
                countOdd++;
            }
        }

        return true;
    }


    public boolean isPermutPalindromeAlphaNumeric(String s) {
        // alpha numeric
        // if the char.tolowercase  is  a=97, z=122, 0=48,57
        s = s.toLowerCase();
        if(s== null || s.length() < 1){
            return true;
        }
        int[] counts = new int['z'-'a' +('9' - '0') + 2];

        //r-2,1-3,c-2,e1, rac ea car
        for(int i = 0; i< s.length(); i++){

            if( s.charAt(i) >= 48 && s.charAt(i) <= 57){
                counts[s.charAt(i) - 48] ++;
            }
            if((int) s.charAt(i) >= 97 && (int) s.charAt(i) <= 122){
                counts[s.charAt(i)- 97]++;
            }
        }
        int cntOdd = 0;
        for(int i = 0; i<counts.length; i++){
            if(cntOdd >1) {
                return false;
            }
            if(counts[i] %2 !=0){
                cntOdd ++;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] counts = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
        int[] a = new int['z'-'a'];
//        System.out.println(counts.length);
//        System.out.println(a.length);
        int[] testa = new int[3];
//        for(int i = 0; i< testa.length; i++){
//            System.out.print(testa[i] + ", ");
//        }
        System.out.println(isPalidromePermutation("geeksforgeeks"));
        System.out.println(isPalidromePermutation("geeksogeeks"));


    }

}
