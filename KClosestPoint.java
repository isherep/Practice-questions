import java.util.PriorityQueue;

public class KClosestPoint {
    public int[][] kClosest(int[][] points, int K) {

        int[][] res = new int[K][2];
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);

        for(int[] point: points){
            heap.offer(point);
        }
        for(int i = 0; i<K; i++){
            res[i] = heap.poll();
        }

        return res;

    }
}
