import java.util.Stack;

/**
 * Find missing parenthesis in a given expression – 2 * ( 3 + 5(sasdfasdfasd)
 *
 *https://www.techiedelight.com/find-duplicate-parenthesis-expression/
 * Stack
 * (
 * 5
 * +
 * 3
 * (
 * *
 * 2
 *
 *
 * Second stack - put the parenthesises in there
 * before checking - check the latest item in the stack
 *
 * Put all oposite parenthesis in the second stack
 *
 * pop the first stack, and for every pop parenthesy - look for it's oposite in the stack
 *
 * pop ( - stack2.pop(')')
 * pop ( - stack2 is empty, so that means that ')' is a missing parenthesy
 *
 * for(each char in string){
 *     stack1.push()
 *     if(char = '('){
 *         push into first stack
 *     }
 *
 *     if(char = ')'){
 *         stack2.push;
 *     }
 * }
 *
 * // if one stack1.size() != stack2.size() {
 *     some parenthesys is missing
 * }  Time complexity - O(n)
 * // Space = O(parenthsis n);
 *
 *
 *
 *
 * while(stack1.isEmtpty()){
 *      pop.element
 *
 *      if(element == '('){
 *         if(stack2.isEmpty()){
 *  *
 *  *     }
 *      }
 *
 * }
 *
 *
 * Approach 2
 *
 * Go over the array
 * If find "(" or ')'  - push into stack
 * if find "(" or ')' - check if stack contains the oposite.
 * if none of current or oposite present - push
 * (, (, )
 *
 * // If stack size is even - no missing parenthesis
 * // else - pop until the size is 1
 *
 *
 * Leftover parenthesy - will be the oposite of missing one.
 *
 * (()() - create counts of each parenthesy  and count when poppong
 * count( = 3  - missing  (.
 * count ) = 4
 *
 *
 *
 * Approach 3 -
 * 1. the closed parenthesis ) can happen only
 * after open (. If you see closed and the stack doesnt't have open - "(m missing
 *
 * If open parenthesis - push
 *
 * than if after popping and matching parenthesis your count is left to 1 -
 * peek at the parenthesy there, it has to be only open one
 *
 *
 * ((), push (, if ) - pop, if nothing to pop - missing open
 *
 *
 *  Stack - (
 *
 * // if the last item in the stack - ( - than missing is )
 * // if the last item in the stack - ) - than missing is (
 * // if the stack is empty - no missing parenthesis
 *
 * Stack methods: emtpy, push, pop, peek, search
 */

public class MissingParenthesis {

    public static void thirdApproach(String str) {
        if(str.equals(null) || str.length() <=1){
           System.out.println("Invalid Ergument");
        }
        Stack<Character> s = new Stack<>();
        for(int i = 0; i< str.length(); i++){
            char cur = str.charAt(i);
            if(cur == '('){
                s.push(cur);
            }
            if(cur == ')'){
                // check the previous element
                if(s.isEmpty()){
                    System.out.println("Missing parenthesis is " + '(');

                }
            }
        }
// because for every closing ) parentesy we pop the previous one, the only way
        // the stack can be non-empty - if we ra out of closing parenthesis and got only open
            while(s.size() >=1){
                s.pop();
                System.out.println("Missing parenthesis is: " + ')');

            }
    }

    public static void main(String[] args){
        thirdApproach("2 * ( 3 + 5(sasdfasdfasd)");
        thirdApproach("2 * ( 3))");
        thirdApproach("()())");
        thirdApproach("(((");
        thirdApproach(")))");
    }



}
