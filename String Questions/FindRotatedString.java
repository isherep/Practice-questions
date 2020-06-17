/**
 * Given two strings, the task is to find if a string ('a') can be obtained by rotating
 * another string ('b') by two places.
 * Examples:
 * Input : a = "amazon"         b = "azon am"  // b.substring (length - 2)rotated anti-clockwise
 *
 * Output : True
 *
 * Input : a = "amazon"        b = "on amaz"   b.substring (2) // rotated clockwise
 *
 * Output : True
 */
public class FindRotatedString {

    public static boolean isRotated(String a, String b) {

        if ((a.length() != b.length()) || a.length() < 2 || b.length() < 2) {
            return false;
        }
        if (a.indexOf(b.substring(2)) == 0) {
            // check if the last 2 char equal to  contains b.substring(0,2)
            System.out.println(a.substring(a.length() - 2) + ",  " + b.substring(0, 2));
            return a.substring(a.length() - 2).equals(b.substring(0, 2));
        } else if (a.indexOf(b.substring(0, b.length() - 2)) == 2) {
            System.out.println(a.substring(0, 2) + ", " + b.substring(b.length() - 2));
            return a.substring(0, 2).equals(b.substring(b.length() - 2));
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println(isRotated("amazon", "azonam"));

    }
}
