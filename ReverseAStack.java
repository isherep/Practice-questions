import java.util.Stack;

/**
 * Reverse a stack and put the reversed value back in the same stack.
 * You can use only one other stack and a temp variable
 */
public class ReverseAStack {
    /*
    While the stack is not empty - more the
     */
    public static void reverse(Stack<Integer> s1){

        Stack<Integer> s2 = new Stack<Integer>();


        int s = s1.size();
        int temp = s1.pop();
        s2.push(s1.pop());

        s1.push(temp);
        s1.push(s2.pop());

        int popped = 2;

        for(int i = 1; i< s-1; i++){
            // push 2 next time
            // so remember where you last popped.
            // stoping point popped = 4
            int j = 0;
            // popped = 2
            while(j < popped ){
                s2.push(s1.pop());
                j ++;
            }
            temp = s1.pop();
            popped ++;
            // temp has to be after all previous were put into stack
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            s1.push(temp);
        }
    }

    public static void main(String[] args){

        Stack<Integer> s = new Stack<>();
        for(int i = 1; i< 8;i++){
            s.push(i);
        }

        reverse(s);

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

}
