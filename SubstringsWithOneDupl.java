import java.util.*;
import java.util.HashSet;

public class SubstringsWithOneDupl {

// Time complexity - O(N^3)
    public static List<String> SubString(String str, int n) {

        List<String> list = new ArrayList<>();

        if(str.length() <=1) {
            return list;
        }

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++) {              //O(N^2)
                // go though each substring, convert it to a set and check if the diff is 1 - put in the list
                String sub = str.substring(i,j);
                // convert substing to a set
                char[] chars =  sub.toCharArray();
                Set<Character> set = new HashSet<>();
                                                                        //
                for (char c: chars) {
                    set.add(c); // amortised substring time O(1/2N)
                }
                if(sub.length() - set.size() == 1){
                    list.add(sub);
            }
    }
            return list;
    }

    public static void main(String[] args)
    {
        List l = SubString("Missisippi", 10);
        for( Object s: l){
            System.out.println(s);
        }
    }
}

