import java.util.ArrayList;
import java.util.List;

/**
 * Backtracking problem has 3 keys to solving
 *
 * 1. Our choice
 *
 * 2. Our constrains - 1. cannot close bracket that was not open
 *                      2. Cannot put more closing than opening
 *
 * 3. Our Goal
 *
 * Can I do a closing bracket - yes you can if the amount of open brackets < closed brackets
 *
 * Can I do an open bracket - yes if open < n
 *
 */
public class GenerateParenthesis {

    public static  void generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
       generateOneByOne("", list, n, n);
        //return list;
    }
    public static void generateOneByOne(String sublist, List<String> list, int open, int closed){
        if(open > closed){
            return;
        }
        if(open > 0){
            generateOneByOne( sublist + "(" , list, open-1, closed);
            System.out.println(sublist);
        }
        if(closed > 0){
            generateOneByOne( sublist + ")" , list, open, closed-1);
        }
        if(open == 0 && closed == 0){
            list.add(sublist);
            return;
        }
    }

    public static void main(String[] args){
        generateParenthesis(3);
    }
}
