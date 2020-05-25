import java.util.Stack;

public class MissingParenthesis2 {
    public static void thirdApproach(String str) {
        if (str.equals(null) || str.length() <= 1) {
            System.out.println("Invalid Ergument");
        }
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                s.push(c);
            }
            if(c == ')'){
                if(s.isEmpty()){
                    System.out.println("Missing parenthesy " + '(');
                } else {
                    s.pop();
                }
            }
        }

        while(!s.isEmpty()){
            System.out.println("Missing parenthesy " + ')');
            s.pop();
        }

    }

    public static void main(String[] args){
        thirdApproach("2*(3+5(w)");
        thirdApproach("2 * ( 3))");
        thirdApproach("()())");
        thirdApproach("(((");
        thirdApproach(")))");
    }
}
