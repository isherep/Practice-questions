import java.util.HashMap;

public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            String prev = words[i - 1];
            // keep checking if first word is lexiographically larger than second
            if (isFirstBiggger(prev, cur, map)) {
                return false;
            }
        }
        return true;
    }

    public boolean isFirstBiggger(String prev, String cur, HashMap<Character, Integer> map) {
        int smLength = cur.length() < prev.length() ? cur.length() : prev.length();
        for (int j = 0; j < smLength; j++) { // 0...4
            // if chars are the same don't do thinng, compare their ranks if they are different
            if (cur.charAt(j) != prev.charAt(j)) {
                return map.get(cur.charAt(j)) < map.get(prev.charAt(j));
            }
        }
        return prev.length() > cur.length();
    }

}
