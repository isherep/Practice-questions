public class TownJudge {
    /*

    public int findJudge(int N, int[][] arr) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];

        for (int[] t : inDegree) {
            outDegree[t[0]]++;
            inDegree[t[1]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    /*
    [[1,3],[2,3]] - 1 trust 3, 2 trust 3. Means 3 is a judge
    [[1,3],[2,3],[3,1]] - no judge, because everyone has to trust him


    // Is this a graph that has one adjacent vertex for each?
    1  - 3
    2 -  3

    1 -

    // create an array of people who trust someone

    [1,2,3]

    // create an array of people who are being trusted.
    [3,3,3]

    If all the elements of the array are the same - than its a town judge

        [[1,3],[1,4],[2,3],[2,4],[4,3]]

     */

    /*
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1]; // N = 4

        int[] trustees = new int[N];
        int[] trusted = new int[N];

        for(int[] t: trust){
            // add trustees into the array
            trustees[t[0]] ++;
            trusted[t[1]]++;


            // add trusts into the array
        }
*/
        /*
        for (int[] t: trust) {
            // decrement the count of trastees the count of
            count[t[0]]--;
            // increment the trusted person trusts
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            // if there are N people, N-1 person has to trust the judge
            // iterate over array of trusts and see which position has the N-1 trusts
            if (count[i] == N - 1) return i;
        }
        return -1;
    }*/
}
