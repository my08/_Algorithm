package leetcode.stringAndArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _06_253_MeetingRooms2 {
    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        _06_253_MeetingRooms2 a = new _06_253_MeetingRooms2();
        Interval in1 = new Interval(0, 30);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(15, 20);

        Interval[] intervals = {in1, in2, in3};
        System.out.println(a.solve(intervals));
    }

    public int solve(Interval[] intervals) {

        int cnt = 1;
        Arrays.sort(intervals, (a,b)->a.start-b.start);
        if (intervals == null) return 0;

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start){
                cnt++;
            }else{
                if(!(intervals[i].start < intervals[i+1].start) || !(intervals[i].end < intervals[i].end)){
                    continue;
                }
                cnt++;
            }
        }
        return cnt;

    }
}
