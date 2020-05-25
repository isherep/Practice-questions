import java.util.Stack;

/*
* we decompose a hard problem into reasonable easy one:
Just find the next greater element in the array, on the left and one right.
Refer to the problem 503. Next Greater Element II


Time O(N) for one pass
Space O(N) for stack in the worst cases

* */
public class MinimumCostTreeFromLeaves {


    // using stack
    public static int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            // the max product will be when multiplied between larger number
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }

    public static void main(String[] args){
        int[] A = {6,2,4};
        System.out.println(mctFromLeafValues(A));
    }
}
