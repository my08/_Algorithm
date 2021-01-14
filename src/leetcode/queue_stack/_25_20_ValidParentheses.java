package leetcode.queue_stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _25_20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([}}])"));
    }
    /*
    Runtime: 2 ms, faster than 29.71% of Java online submissions for Valid Parentheses.
    Memory Usage: 37.1 MB, less than 77.23% of Java online submissions for Valid Parentheses.
     */
    public static boolean isValid(String s) {

        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<cs.length; i++){
            if(stack.isEmpty()){
                stack.push(cs[i]);
            }else{
                if(('{' == stack.peek() && '}' == cs[i])
                || ('[' == stack.peek() && ']' == cs[i])
                || ('(' == stack.peek() && ')' == cs[i])){
                    stack.pop();
                }else{
                    stack.push(cs[i]);
                }
            }
        }

        if(stack.isEmpty()) return true;
        return false;
    }

    public static boolean isValidLecture(String s) {

        if(s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case ')' :
                    if(!stack.empty() && stack.peek() == '(') stack.pop();
                    break;
                case ']' :
                    if(!stack.empty() && stack.peek() == '[') stack.pop();
                    break;
                case '}' :
                    if(!stack.empty() && stack.peek() == '{') stack.pop();
                    break;
                default :
                    stack.push(s.charAt(i));
                    break;
            }
        }

        return stack.empty();
    }
}
