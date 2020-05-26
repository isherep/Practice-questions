public class FindElementInSortedMatrix {
    // given matrix who's rows and columns are sorter - find el
    public static int find(int[][] mtx, int num) {
        if (mtx == null || mtx.length < 1) {
            throw new IllegalArgumentException("Matrix is null or empty");
        }
        int m = mtx.length;
        int n = mtx[0].length;
        int i = 0; // row idx
        int j = 0; //col idx
        // if num smaller than first el or larger that last el.
        if (num < mtx[0][0] || num > mtx[m - 1][n - 1]) {
            return num;
        }
        while (i < m && j < n) {
            // if the first row item is
            if (mtx[i][0] == num) {
                return num;
            } else if (mtx[i][0] < num && num < mtx[i][n - 1]) {
                // if its in the current row -look inside that row
                // row will be i
                return binSearch(mtx[i], num, 0, n - 1);
            } else if (mtx[i][n - 1] < num) {
                // move to next row
                i++;
                // if it's last element
            } else if (mtx[i][n - 1] == num) {
                return mtx[i][n - 1];
            }
        }
        return -1;
    }

    public static int binSearch(int[] a, int target, int lo, int hi) {

        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2; // 0 + 3/2 = 1.5 = 1
        // column j will be mid);
        if (a[mid] == target) {
            //System.out.print(mid);
            return target;
        } else if (a[mid] < target) {
            return binSearch(a, target, lo, mid - 1);
        } else {
            return binSearch(a, target, mid + 1, hi);
        }

    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3, 4},
                {10, 12, 23, 24},
                {31, 32, 33, 34},
                {39, 40, 42, 45}};

        int res = find(m, 40);
        System.out.println(res);
    }

}
