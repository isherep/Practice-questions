import java.util.Arrays;
import java.util.Comparator;

public class KClosestPoints {
   // SQR(x2−x1)2+(y2−y1)2+(z2−z1)/2
    public int[][] kClosest(int[][] points, int K) {

        Comparator<int[]> myComp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    return (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0] * o2[0]+ o2[1] * o2[1]);
            }
        };

        Arrays.sort(points, myComp);
        int[][] res = new int[K][2];

        //create a copy of the array
        for(int i = 0; i< K; i++){
          res[i][0] = points[i][0];
          res[i][1] = points[i][1];

        }
          return res;
    }

}
