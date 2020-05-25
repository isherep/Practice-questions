public class ContainerWithMostWater {


    // Brute-Force
    public static int mostWaterBrute(int[] height) {

        int maxSquare = 0;
        for(int i = 0; i< height.length; i++){
            for(int j = 1; j< height.length; j++){
                int l = j-i;
                int h = Math.min(height[i], height[j]);
                int square = l*h;
                if(square > maxSquare){
                    maxSquare = square;
                }
            }
        }


        return maxSquare;
    }

    public static int mostWaterFast(int[] height){
        // start from end and start
        // calc the area, compare to max, if >m -> max
        // // find the shorter bar and move that bari
        int maxSq = 0;
        int j = height.length -1;
        for(int i = 0; i < j; i++){
            int l = j - i;
            int h = Math.min(height[j], height[i]);
            int square = l * h;
            if(square > maxSq){
                maxSq = square;
            }
            // move smaller pointer
            if(height[j] <= height[i]){
                j--;
                i--;
            }
        }

        return maxSq;
    }

    public static void main(String[] args){
        int[] arr  = {1,8,6,2,5,4,8,3,7};
        int[] arr1  = {1,1};
        System.out.print(mostWaterFast(arr));


    }
}
