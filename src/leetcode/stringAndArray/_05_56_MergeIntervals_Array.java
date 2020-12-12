package leetcode.stringAndArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _05_56_MergeIntervals_Array {
    public static void main(String[] args) {

        int[][] intervals = {{1,4},{0,4}};
        int[][] answer = merge(intervals);
        for (int i = 0; i < answer.length; i++) {
            if(answer[i][0] == 0 && answer[i][1] == 0){
                break;
            }
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }
    }

    private static int[][] merge(int[][] intervals) {
//      Runtime: 43 ms, faster than 5.09% of Java online submissions for Merge Intervals.
//      Memory Usage: 42 MB, less than 26.25% of Java online submissions for Merge Intervals.

        int[][] answer = new int[10001][2];
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int idx = 0;
        int[] std = intervals[0];

        for(int i=1; i<intervals.length; i++){
            int[] current = intervals[i];
            if(std[1] >= current[0]){
                std[1] = Math.max(std[1], current[1]);
                std[0] = Math.min(std[0], current[0]);
            }else{
               answer[idx][0] = std[0];
               answer[idx][1] = std[1];
               std = current;
               idx++;
            }
        }

        if(answer[idx][0] != std[0] || answer[idx][1] != std[1]){
            answer[idx][0] = std[0];
            answer[idx][1] = std[1];
        }


        int[][] result = new int[idx+1][2];
        for (int i = 0; i <= idx; i++) {
            result[i][0] = answer[i][0];
            result[i][1] = answer[i][1];
        }

        return result;
    }
}
