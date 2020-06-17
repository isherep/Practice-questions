public class compressString {

    public static String compressStr(String str){

    if (str.length() <= 1) {
        return str;
    }
    StringBuilder sb = new StringBuilder(str.length() + 1);
    char currChar = str.charAt(0);
    int currCount = 1;
    for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == currChar) {
            currCount++;
        } else {
            sb.append(currChar);
            sb.append(currCount);

            currChar = str.charAt(i);
            currCount = 1;
        }
    }
    sb.append(currChar);
    sb.append(currCount);

        if(sb.length() > str.length()) {
            return str;
        }

    return sb.toString();
}

    public static String compress(String str) {
        StringBuilder compressed= new StringBuilder();
        int countConsecutive = 0;
        int lastBeforeEnd = Integer.MIN_VALUE;
        for (int i= 0; i < str.length()-1; i++) {
            countConsecutive++;
            System.out.println("Count consecutive " + countConsecutive);

            /* If next character is different than current, append this char to result.*/

            if (
                    //i + 1 >= str.length() ||
                            str.charAt(i) != str.charAt(i + 1)) {

                System.out.println("str.charAt(i):" + str.charAt(i));
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
            lastBeforeEnd = str.charAt(i+1);
        }

        // handling last character
        if(str.charAt(str.length() -1) == lastBeforeEnd){
            compressed.append(str.charAt(str.length() -1));
            compressed.append(countConsecutive +1);
        }  else {
            compressed.append(str.charAt(str.length() -1));
            compressed.append(1);
        }

        //  handle last character
        return compressed.length() < str.length() ? compressed.toString() : str;
    }





    public static void main(String[] args){
        //aabcccccaaa would become a2blc5a3
        String s = "aabcccccaak";

        System.out.println(compress(s));
        System.out.println(compressStr(s));
    }


//    for(int i = 0; i < initialLength; i++){
//        char c  = chars[i];
//        if(currentChar == c) {
//            occurances++;
//        } else {
//            compressedString += currentChar + String.valueOf(occurances);
//            currentChar = c;
//            occurances = 1;
//        }
//    }
//    compressedString += currentChar + String.valueOf(occurances);
}
