import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 1; i > 0; i--) {
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (map.get(prev) < map.get(cur)) {
                res -= map.get(prev);
            } else {
                res += (map.get(prev));
            }
        }
        return res;
    }
}
