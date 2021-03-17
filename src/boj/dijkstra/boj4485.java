package boj.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0
 */
public class boj4485 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 1;
        int index = 1;
        while(N != 0) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int[][] matrix = new int[N][N];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = dijkstra(matrix, N);
            bw.write("Problem " + index++ + ": " + Integer.valueOf(answer) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static int dijkstra(int[][] matrix, int n) {
        int[][] cost = new int[n][n];
        for(int[] c : cost) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }
        cost[0][0] = matrix[0][0];

        Queue<int[]> queue= new LinkedList<int[]>();
        queue.offer(new int[] {0, 0});
        while( !queue.isEmpty() ) {
            int[] xy = queue.poll();
            for(int[] dir : dirs) {
                int tx = xy[0] + dir[0];
                int ty = xy[1] + dir[1];
                if(tx >= 0 && tx < n && ty >= 0 && ty < n) {
                    if(cost[tx][ty] > cost[xy[0]][xy[1]] + matrix[tx][ty]) {
                        cost[tx][ty] = cost[xy[0]][xy[1]] + matrix[tx][ty];
                        queue.offer(new int[] {tx,ty});
                    }
                }
            }
        }

        return cost[n-1][n-1];
    }

}

