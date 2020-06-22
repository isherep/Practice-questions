/**
 * Given a string, recursively remove adjacent duplicate characters from string. The output string should not have any adjacent duplicates. See following examples.
 * Input:  azxxzy
 *
 * Output: ay
 *
 * First "azxxzy" is reduced to "azzy". The string "azzy" contains duplicates, so it is further reduced to "ay".
 *
 * Input: caaabbbaacdddd
 *
 * Output: Empty String
 *
 * Input: acaaabbbacdddd
 *
 * Output: acac
 */
public class StringRemoveAdjDuplsRecurs {

    private static  StringBuilder sb = new StringBuilder();

    public static void RemoveDupls(String s){

        if(s.length() <= 2){
            sb.append(s.charAt(s.length()-1));
            return;
        }
        if(s.charAt(0) != s.charAt(1)){
                sb.append(s.charAt(0));
                RemoveDupls(s.substring(1));
        } else {
            // put duplicates into some forbiden set
            // check every number if it is not forbidden
            RemoveDupls(s.substring(2));
            // remember that character and don't append any of it
        }
    }

    public static String removeDuplicates(String S) {
        // create new stringbuilder using string
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                // end index is exclusive
                return removeDuplicates(S.substring(0, i) + S.substring(i + 2));
            }
        }
        return sb.toString();
    }
     /***************************************************************/

    // Recursively removes adjacent duplicates from str and returns
    // new string. last_removed is a pointer to last_removed character
    static String removeUtil(String str, char last_removed)
    {
        // If length of string is 1 or 0
        if (str.length() == 0 || str.length() == 1)
            return str;
        // Remove leftmost same characters and recur for remaining
        // string
        if (str.charAt(0) == str.charAt(1))
        {
            last_removed = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1);
            // else new string starts at second char
            str = str.substring(1);
            return removeUtil(str, last_removed);
        }
        // At this point, the first character is definately different
        // from its adjacent. Ignore first character and recursively
        // remove characters from remaining string

        // else - if the chars are not the same:
        String rem_str = removeUtil(str.substring(1), last_removed);

        // Now check if the removed portions start is same as first char
        while (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0))
        {
            //last_removed = str.charAt(0);
            rem_str =  rem_str.substring(1); // Remove first character
        }
        // If remaining string becomes empty and last removed character
        // is same as first character of original string. This is needed
        // for a string like "acbbcddc"
        if (rem_str.length() == 0 && last_removed == str.charAt(0))
            return "";

        // If the first characters of str and rem_str don't match,
        // append first character of str before the first character of
        // rem_str
        return (str.charAt(0) + rem_str);
    }

    static String remove(String str)
    {
        char last_removed = '\0';
        return removeUtil(str, last_removed);
    }



    public static void main(String[] args){
        String s = "appppppppple";
        String s1 = "acaaabbbacdddd"; // acac
        String s2 = "caaabbbaacdddd"; // ""
        //RemoveDupls(s2);
//        System.out.println(sb.toString());
//        System.out.println("finished");

        String str3 = "caaabbbaac";
        System.out.println(remove(s2));
        System.out.println("finished");
    }



}
