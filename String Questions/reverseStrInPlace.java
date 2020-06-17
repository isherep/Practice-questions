public class reverseStrInPlace {

    public static void reverse(String s){
       final StringBuilder builder = new StringBuilder(s);
       int length = builder.length();
       for (int i = 0; i < length / 2; i++) {
           final char current = builder.charAt(i);

           final int otherEnd = length - i - 1;
           builder.setCharAt(i, builder.charAt(otherEnd)); // swap builder.setCharAt(otherEnd, current); } return builder.toString(); }
       }
        //return builder.toString();

    }

    public static void main(String[] args){

    }
}
