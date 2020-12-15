package leetcode.stringAndArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _06_253_MeeingRooms2_Queue {
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
        _06_253_MeeingRooms2_Queue a = new _06_253_MeeingRooms2_Queue();
        Interval in1 = new Interval(0, 4);
        Interval in2 = new Interval(4, 5);
        Interval in3 = new Interval(4, 6);

        Interval[] intervals = {in1, in2, in3};
        System.out.println(a.solve(intervals));
    }

    public int solve(Interval[] intervals) {

        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b)->a.start-b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, (a,b)->(a.end-b.end));
        int max = 0;
        for(int i=0; i<intervals.length; i++){

            while(!pq.isEmpty() && pq.peek().end <= intervals[i].start) {
                pq.poll();
            }
            pq.offer(intervals[i]);
            max = Math.max(max, pq.size());

        }
        return max;

    }
}
