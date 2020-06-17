import java.util.*;

public class WordSplit {

    Map<String, Boolean> map = new HashMap<String, Boolean>();

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        Collections.sort(wordDict);
        for (int i = 0; i < wordDict.size(); i++) {
            // if substring index is there
            String cur = wordDict.get(i);
            int idx = s.indexOf(cur);
            int lastIdx = -1;
            if (idx != -1) {
                // find the ending index.
                lastIdx = idx + cur.length();
                if (idx == 0) {
                    // recurse down to the end of the string
                    return wordBreak(s.substring(lastIdx), wordDict);
                    // if the index found was first idx
                } else {
                    // return the result before the fond word and after the found word
                    return wordBreak(s.substring(0, idx), wordDict) && wordBreak(s.substring(lastIdx), wordDict);
                }
            }
            // I can crate a list of checked words (words,i) which do not tough on next iteration
            //
            // then go back to the full string and search a different word besides cur
        }
        return false;
    }

    public static void main(String[] args) {
        List wordDict = new ArrayList();
        wordDict.add("leet");
        wordDict.add("code");
        //wordDict.add("apple");

        String s = "cars";
        // what if I sort the dictionary - it will put shorter words first
        String[] dic = {"car", "ca", "rs"};
        List test = new ArrayList();
        for (String str : dic) {
            test.add(str);
        }

        //System.out.println(wordBreak("leetcodeapple", wordDict));
        System.out.println(wordBreak("cars", test));
    }


    public boolean wordBreakMap(String s, List<String> wordDict) {

        if (s.length() == 0) return true;

        if (map.containsKey(s) && !map.get(s)) return false;
        for (String str : wordDict) {
            int len = str.length();
            if (s.indexOf(str) == 0) {
                if (wordBreakMap(s.substring(len), wordDict)) {
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

}
