public class ReverseStrings {

    public static String reverseIter(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i<j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new String(chars);
    }

    public static String reverseRecurs(String s){
        if (s.isEmpty()){
            System.out.println("String in now Empty");
            return s;
        }
        //Calling Function Recursively
        System.out.println("String to be passed in Recursive Function: "+ s.substring(1) +  "s.charAt(0) to be passed in Recursive Function: "+ s.charAt(0));
        return reverseRecurs(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args){
        String s = "apple";
        System.out.print(reverseRecurs(s));
    }
}
