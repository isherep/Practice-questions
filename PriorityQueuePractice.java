import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePractice {

    public static void main(String[] args){
        PriorityQueue<Integer> naturalOrd = new PriorityQueue<Integer>();
        for(int i = 10; i > 0; i-- ){
            naturalOrd.add(i);
        }

        while(!naturalOrd.isEmpty()){
            System.out.print(naturalOrd.poll() + ",");
            // 1,2,3,4,5,6,7,8,9,10, - in natural ordering
        }


        // custom string comparator
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        Comparator<String> comparator = (s1, s2) -> {
            return s2.length()-s1.length();
        };
        PriorityQueue<String> q = new PriorityQueue<>(comparator);

        q.add("d");
        q.add("dfa");
        q.add("dfasidfas");
        q.add("dfa");
        q.add("df");
        q.add("dfasi");
        q.add("dfasidfashdifowafcnk");
        q.add("d");
        q.add("dfasidfashdifo");

        while(!q.isEmpty()){
            System.out.print(q.remove() + ",");
        }

    }
}
