import java.util.Stack;

/**
 * Evaluate an expression given only single digits and only 2 operators * and +.
 */
public class EvaluateExpression {

    public static int evaluateExp(String str){
        int res = 0;
        char[] chars = str.toCharArray();
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i< chars.length; i++){
            if(chars[i] != '+' && chars[i] != '*'){
                int cur = Character.getNumericValue(chars[i]);
                System.out.println("Current " + cur + " " + chars[i]);
                s.push(cur);
            }

            if(chars[i] == '*'){
                int last = s.pop();
                s.push(last*Character.getNumericValue(chars[i+1]));
                i++;
            }
        }

        while(!s.isEmpty()){
            res+=s.pop();
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(evaluateExp("2+4"));
        System.out.println(evaluateExp("2+4*6"));
        System.out.println(evaluateExp("2*4+6"));
    }
}
