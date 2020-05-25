import java.util.Stack;

public class AddOneToInteger {

    // using stack
    public int[] plusOne(int[] digits) {
        if(digits ==null || digits.length < 1){
            return digits;
        }
        int last = digits.length -1;
        System.out.println(last);
        if(digits[last] != 9){
            digits[last] +=1;
            return digits;
        } else {
            Stack<Integer> s = new Stack<Integer>();
            int carry = 1;
            s.push(0);
            for(int i = last-1; i>=0; i--){
                //carry+=1;
                if((digits[i] + carry) >= 10){
                    s.push(0);
                } else {
                    s.push(digits[i] + carry);
                    carry = 0;
                }
            }

            if(carry >0){
                s.push(carry);
            }

            int[] res = new int[s.size()];
            int i = 0;

            while(! s.isEmpty()){
                res[i] = s.pop();
                i++;
            }
            return res;

        }

    }

}
