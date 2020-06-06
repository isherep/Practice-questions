import java.util.Stack;

public class RemoveParenthesis {

    // one way to keep boolean array with true where the invalid parenthesis was.
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] valid = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
                //valid[i] = true; // the key here is not to set open bracket to true,
                // but only in the case when closing bracket will be mached, we'll set it to true
            } else if (cur == ')') { //
                if (!stack.isEmpty()) { // if there were ( opening brackets
                    // set current closing index to true
                    // and last opening index to true
                    valid[i] = true;
                    valid[stack.pop()] = true;  // than pop them and set the char to true
                }
            } else {
                valid[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valid.length; i++) {
            if (valid[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    // second way to keep a track of indexes where the parenthesy was
    public String minRemoveToMakeValidIdx(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    st.push(i);
                    break;
                case ')':
                    if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
                        st.pop();
                    } else {
                        st.push(i);
                    }
                    break;
            }
            sb.append(s.charAt(i));
        }
        while (!st.isEmpty()) {
            sb.deleteCharAt(st.pop());
        }
        return sb.toString();
    }
}
