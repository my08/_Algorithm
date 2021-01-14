package leetcode.queue_stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _24_682_BaseballGame {
    public static void main(String[] args) {
        String[] request = {"1"};
        System.out.println(calPoints(request));

    }
    /*
    Runtime: 2 ms, faster than 89.96% of Java online submissions for Baseball Game.
    Memory Usage: 38.1 MB, less than 82.67% of Java online submissions for Baseball Game.
     */
    public static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<ops.length; i++){
            if("C".equals(ops[i])){
                stack.pop();
            }else if("D".equals(ops[i])){
                stack.push(stack.peek() * 2);
            }else if("+".equals(ops[i])){
                int reinput = stack.pop();
                int pushNum = stack.peek() + reinput;
                stack.push(reinput);
                stack.push(pushNum);
            }else{
                stack.push(Integer.parseInt(ops[i]));
            }
        }

        int answer = 0;
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;

    }

    public static int calPointsLecture(String[] ops) {

        Stack<Integer> stack = new Stack<>();
        for(String op : ops){
            switch(op){
            case "C" :
                stack.pop();
                break;
            case "D" :
                stack.push(stack.peek()*2);
                break;
            case "+":
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y);
                stack.push(x);
                stack.push(x+y);
                break;
            default:
                stack.push(Integer.valueOf(op));
            }

        }

        int answer = 0;
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;

    }
}
