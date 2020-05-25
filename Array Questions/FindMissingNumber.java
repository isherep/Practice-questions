public class FindMissingNumber {

    //1. If only one number missing

    // using the sum formula finds missing number from 1 to 100
    // you might need long for sum
    public int findSumWay(int[] n, int num){
        int sumOfSequence = num * (num-1)/2;
        int actulSum = 0;
        for(int i = 0; i<n.length; i++){
            actulSum +=i;
        }

        return sumOfSequence - actulSum;
    }

    public int findMissingXOR(int[] arr, int n){
        // find the XOR for the sequence
        int sumArr =0;
        int X = 1;
        for(int i = 2; i<= n; i++){
           X = X^i;
        }
        // find XOR for the actual array
        for( int i = 0; i< arr.length; i++){
            sumArr = sumArr ^ arr[i];
        }

        return (X ^ sumArr);
        // substract one XOR form another

    }
    //
}
