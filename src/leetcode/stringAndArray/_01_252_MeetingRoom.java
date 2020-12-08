package leetcode.stringAndArray;

import java.util.Arrays;
import java.util.Comparator;

class Interval{
    int start;
    int end;
    Interval(){
        this.start = 0;
        this.end = 0;
    }
    Interval(int s, int e){
        this.start = s;
        this.end = e;
    }

}
class _01_252_meetingRoom {
    public static void main(String[] args) {
        _01_252_meetingRoom a = new _01_252_meetingRoom();


        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(0,30);

        Interval[] intervals = {in1, in2,in3};
        System.out.println(a.solve(intervals));
    }

    public boolean solve(Interval[] intervals){

        if(intervals == null) return false;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end > intervals[i+1].start){
                return false;
            }
        }

        return true;

    }

}
