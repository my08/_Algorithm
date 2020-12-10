package leetcode.stringAndArray;

import java.util.Stack;

public class _04_739_dailyTemperatures {
    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = dailyTemperatures(temp);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

    }

    public static int[] dailyTemperatures(int[] T) {
        //Runtime: 14 ms, faster than 73.57% of Java online submissions for Daily Temperatures.
        //Memory Usage: 47.1 MB, less than 65.92% of Java online submissions for Daily Temperatures.
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        //index를 stack에 저장
        for(int i=0; i<T.length; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
