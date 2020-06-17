import java.util.LinkedList;
import java.util.List;

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        // comment scope
        boolean scope = false;
        StringBuilder sb = new StringBuilder();

        List<String> res = new LinkedList<>();
        // if string character at i == '/' and i+1 = *
        for(String s: source){

            // create a new string builder for every line in the array
            // than do not add empty string builder(case when line was comment), only ones that have content
            for(int i = 0; i< s.length(); i++){
                // if we are already not in corrent mode
                if(scope){
                    // look for closing parenthesis
                    if(s.charAt(i) == '*' && i < s.length()-1 && s.charAt(i+1) == '/'){
                        scope = false;
                        i+=1;
                    }
                } else {
                    // look for opening block
                    if(!scope && s.charAt(i) == '/' && i < s.length()-1 && s.charAt(i+1)=='*'){
                        scope = true;
                        i+=1;
                        // look for line comment - new iteration c will start with no mode
                        // the whole line c has to be script
                    } else if(!scope && s.charAt(i) == '/' && i < s.length()-1 && s.charAt(i+1)=='/'){
                        i+=2;
                        // go to the next string s in source
                        // use break and not continue, because the next iteration is the char and not the array element
                        break;
                        // only comment untill the end of the current s
                    } else{
                        sb.append(s.charAt(i));
                    }
                }
            }

            if (!scope && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }
        return res;
    }
}
