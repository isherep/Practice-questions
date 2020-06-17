/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {
    // start from the end untill you find first space after word
    // than move the word  to the end - and put %20 before it.
    // Decrement the end available
    // than look for next word and space fore - move until new end
    // 5
    // returns new string
    public static String url(String s){
        String url = "";
        // count the length of old string
        // count how many spaces are in old string
        // start from the back.
        //url =
        String repl = "%20";
        for(int i = 0; i < s.length(); i++){
            // add every character to the new string front
            // if the char is ' ' , that ad repl
            char cur = s.charAt(i);
            if(cur != ' '){
                url = url + cur;
            } else {
                url = url + repl;
            }
        }
        return url;
    }

    public static char[] url(char[] chars){
        // length of chars + amount of whitespaces *2
        int spaceCt = 0;
        for(char c: chars){
            if(c == ' '){
                spaceCt ++;
            }
        }
        char[] url = new char[chars.length + spaceCt *2];
        // now start from last char in chars
        // putit into last element in url
        // if ' ' make 3 elements %20, decrement crrent end
        int curEnd = url.length -1;

        for(int i = chars.length - 1; i >=0; i--){
            char c = chars[i];
            // last char of the url array
            if(c != ' '){
                url[curEnd] = c;// curEnd = 16
                curEnd --;
              //  System.out.print(curEnd);
            } else {
                url[curEnd] = '0';
                url[curEnd - 1] = '2';
                url[curEnd -2] = '%';
                curEnd -=3;
            }
        }

        return url;
    }

    public static void main(String[] args){
//        EXAMPLE
//        Input: "Mr John Smith ", 13
//        Output: "Mr%20John%20Smith"
        String s1 = "Mr John Smith";
        System.out.println(url(s1));
        System.out.println(url(s1.toCharArray()));


    }
}
