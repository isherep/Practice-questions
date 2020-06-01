import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {

            Arrays.sort(logs, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int res = 0;
                    // find the second word
                    // find first occurence of whitespace
                    // beginning of second word is after it.
                    int spaceIdxA = a.indexOf(' ');
                    int spaceIdxB = b.indexOf(' ');
                    String ident1 = a.substring(spaceIdxA + 1);
                    String ident2 = b.substring(spaceIdxB + 1);
                    int fc1 = ident1.charAt(0);

                    // if both are characters
                    if (ident1.charAt(0) >= 97 && ident1.charAt(0) <= 122 && ident2.charAt(0) >= 97 && ident2.charAt(0) <= 122) {
                        // compare spaceIdxA and spaceIdxB
                        res = ident1.compareTo(ident2);
                    }
                    // first is numeric and second is char
                    if (ident1.charAt(0) >= 48 && ident1.charAt(0) <= 57 && ident2.charAt(0) >= 97 && ident2.charAt(0) <= 122) {
                        // than place spaceIdxA behind spaceIdxb
                        res = 1;
                    }
                    // character range - 97-122
                    // number range - 48 - 57
                    if (ident1.charAt(0) >= 97 && ident1.charAt(0) <= 122 && ident2.charAt(0) >= 48 && ident2.charAt(0) <= 57) {
                        // than place spaceIdxA behind spaceIdxb
                        res = -1;
                    }

                    if (ident1.equals(ident2)) {
                        // than compare the string a and string b
                        res = a.compareTo(b);

                    }

                    return res;
                }
            });

            return logs;
        }

    }

}
