public class MostCommonElement {
    public static int mode(int[] arr){

        int[] counter = new int[arr.length];

        if(arr.length ==1){
            return arr[0];
        } else {
            for(int i = 0; i< arr.length; i++){
                // each cell corresponds to the count
                // counter[same position as arr[i]];
                // i = 0; counter[arr[0]] -> count of arr[0] 27
                // i = 2; counter[arr[0]] -> count of arr[1] 15
                counter[arr[i]]++;

            }

        }
        for(int i = 0; i< counter.length; i++){
            System.out.print(counter[i] + ",");
        }
        // now find the max;
        int max = 0;
        int mod = 0;

        for(int i = 0; i<counter.length; i++){
            if(counter[i] > max){
                max = counter[i];
                mod = i;
            }
        }
        return mod;

    }
    public static void main(String[] args){
        int[] arr = {27, 15, 15, 11, 27, 27};

        mode(arr);
    }
}
