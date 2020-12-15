package leetcode.stringAndArray;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _09_973_KClosestPointsToOrigin_Queue {

    public static void main(String[] args) {
        int N = 2;
        int K = 1;
        int[][] points = {{1,3},{-2,2}};
        int[][] answer = kClosest(points, K);
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }

    }


    public static int[][] kClosest(int[][] points, int K) {
//      Runtime: 20 ms, faster than 67.80% of Java online submissions for K Closest Points to Origin.
//      Memory Usage: 47.7 MB, less than 55.42% of Java online submissions for K Closest Points to Origin.
        Comparator<? super int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0] + o1[1]*o1[1])
                        - (o2[0]*o2[0] + o2[1]*o2[1]);
            }
        };
        Queue<int[]> queue = new PriorityQueue<>(points.length, comp);
        int[][] result = new int[K][2];
        for(int[] p : points){
            queue.offer(p);
        }
        int index = 0;
        while(index < K){
            result[index] = queue.poll();
            index++;
        }
        return result;
    }
}
