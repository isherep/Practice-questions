import java.util.*;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new LinkedList<>();
        if (words == null || words.length < 1 || k < 0 || k > words.length) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        // fill the hashmap with counts
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        Comparator myComparator = new Comparator();
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(map.size(), myComparator);

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            heap.offer(e);
        }

        for (int i = 0; i < k; i++) {
            res.add(heap.poll().getKey().toString());
        }

        return res;
    }

    private static class Comparator implements java.util.Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue().compareTo(o1.getValue()); // getVal will be object Integer
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        }
    }

    public static void main(String[] args) {
        String[] w = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}; // the -4, is-3
        String[] w1 = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(w, 2);
    }
}
