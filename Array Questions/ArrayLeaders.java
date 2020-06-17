/**
 * Write a program to print all the LEADERS in the array.
 * An element is leader if it is greater than all the elements to its right side.
 * And the rightmost element is always a leader.
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 *
 */
public class ArrayLeaders {

    public static void printLeads(int[] arr){

        int  n = arr.length;

        int curLeader = arr[n-1];

        for(int i = n-2; i > 1; i++){
            if(arr[i-1] < arr[i]){
                System.out.print(arr[i] + ", ");
            }
        }
        // find the element that is larger than previous
        // start from the end
        // keep track of current leader and compare elements
        // if the element is is larger than one behind it - it becomes a leader too
        //
        // iterate back , if some element < current, 16<17 - than the cur.elem is a leader

        //

    }

    public static void main(String[] args){

        int[] arr = {16, 17, 4, 3, 5, 2};//  6
        int  n = arr.length;
        for(int i = n-2; i > 0; i--){
            if(arr[i-1] < arr[i]){
                System.out.print(arr[i] + ", ");
            }
        }
        int curLeader = arr[n-1]; // a[5] = 2
        System.out.print(curLeader + ". ");


    }
}
