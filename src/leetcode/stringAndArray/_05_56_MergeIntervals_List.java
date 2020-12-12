package leetcode.stringAndArray;

import java.util.*;

public class _05_56_MergeIntervals_List {
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
        List<Interval> intervals = new ArrayList<Interval>();

        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(4, 5));

        //List<Interval> answer = mymerge(intervals);
        List<Interval> answer = merge(intervals);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i).start + " " + answer.get(i).end);
        }
    }

    private static List<Interval> merge(List<Interval> intervals) {

        List<Interval> answer = new ArrayList<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval before = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            if (before.end >= current.start) {
                before.end = Math.max(before.end, current.end);
            } else {
                answer.add(before);
                before = current;
            }
        }

        if (!answer.contains(before)) answer.add(before);

        return answer;
    }

    public static List<Interval> mymerge(List<Interval> intervals) {
        List<Interval> answer = new ArrayList<Interval>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                if (answer.size() == 0) {
                    answer.add(new Interval(intervals.get(i).start, intervals.get(i + 1).end));
                } else {
                    for (int j = 0; j < answer.size(); j++) {
                        if (answer.get(j).end >= intervals.get(i + 1).start) {
                            if (answer.get(j).end < intervals.get(i + 1).end) {
                                answer.get(j).end = intervals.get(i + 1).end;
                            }
                        } else {
                            answer.add(new Interval(intervals.get(i).start, intervals.get(i + 1).end));
                        }
                    }
                }
                i++;
            } else {
                answer.add(new Interval(intervals.get(i).start, intervals.get(i).end));
                if (i == intervals.size() - 2) {
                    answer.add(new Interval(intervals.get(i + 1).start, intervals.get(i + 1).end));
                }
            }
        }
        return answer;
    }
}
