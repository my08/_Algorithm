package leetcode.stringAndArray;

import java.util.*;
import java.util.function.DoubleToLongFunction;

public class _09_973_KClosestPointsToOrigin {

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
        //1. PriorityQueue
//      Runtime: 22 ms, faster than 59.95% of Java online submissions for K Closest Points to Origin.
//      Memory Usage: 48.6 MB, less than 11.93% of Java online submissions for K Closest Points to Origin.
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(points.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for(int i=0; i< points.length; i++){
            pq.add(new int[]{i, (int)(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2))});
        }
        int[][] answer = new int[K][2];
        for(int i=K-1; i>-1; i--) {
            int[] point = pq.poll();
            answer[i][0] = points[point[0]][0];
            answer[i][1] = points[point[0]][1];
        }
        //2. Map
//      Runtime: 42 ms, faster than 12.61% of Java online submissions for K Closest Points to Origin.
//      Memory Usage: 47.8 MB, less than 46.40% of Java online submissions for K Closest Points to Origin.
        /*
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        for(int i=0; i< points.length; i++){
            map.put(i, Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
        }

        List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(map.entrySet());
        Collections.sort(list, (a,b)-> (int) (a.getValue()-b.getValue()));

        int[][] answer = new int[K][2];
        for(int i=K-1; i>-1; i--) {
            answer[i][0] = points[list.get(i).getKey()][0];
            answer[i][1] = points[list.get(i).getKey()][1];
        }
        */
        return answer;
    }


}
