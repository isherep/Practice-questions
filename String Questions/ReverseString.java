public class ReverseString {

    public static String reverseRecursive(String word){
        /* The one in brackets will be concatinated
             [o]rd ~ W
              [r]d ~ o
                [d] ~ r
            droW
         */
        if(word == null || word.length() <2){
            return word;
        }
        System.out.println(word.substring(1) +" ~ " + word.charAt(0));

        return reverseRecursive(word.substring(1)) + word.charAt(0);

    }

    public static void main(String[] args){

        String s = "Sony is going to introduce Internet TV soon";
        String word = "Word";

        System.out.print(reverseRecursive(word));


    }
}
