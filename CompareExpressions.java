/**
 * Given two expressions in the form of strings.
 * The task is to compare them and check if they are similar.
 * Expressions consist of lowercase alphabets, ‘+’, ‘-‘ and ‘( )’.
 *
 * Examples:
 *
 * Input  : exp1 = "-(a+b+c)"
 *          exp2 = "-a-b-c"
 * Output : Yes
 *
 * Input  : exp1 = "-(c+b+a)"
 *          exp2 = "-c-b-a"
 * Output : Yes
 *
 * Input  : exp1 = "a-b-(c-d)"
 *          exp2 = "a-b-c-d"
 * Output : No
 * It may be assumed that there are at most 26 operands from ‘a’ to ‘z’
 * and every operand appears only once.
 *
 * If minus before ( and than + after - its valid
 * If minus before ( and - after - not valied
 */
public class CompareExpressions {
}
