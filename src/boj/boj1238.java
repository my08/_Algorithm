package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://velog.io/@agugu95/%EC%9E%90%EB%B0%94-%EA%B7%B8%EB%9E%98%ED%94%84-%EC%B5%9C%EB%8B%A8-%EA%B2%BD%EB%A1%9C%EC%99%80-Dijkstra%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
//Single destination의 경우 방향을 반대로 바꾼 배열을 사용하여 다익스트라 진행
public class boj1238 {
    private static int N, M, X;
    private static int max = 0;
    private static int[][] map, reverseMap;
    private static int[] dist, reverseDist;

    static class Node implements Comparable<Node>{
        int index;
        int distance;
        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance > o.distance ? -1 : 1;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        reverseMap = new int[N+1][N+1];
        dist = new int[N+1];
        reverseDist = new int[N+1];
        Arrays.fill(dist, N*100);
        Arrays.fill(reverseDist, N*100);
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = N*100;
                reverseMap[i][j] = N*100;
            }
        }
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(map[s][e] > c){
                map[s][e] = c;
            }
            if(reverseMap[e][s] > c){
                reverseMap[e][s] = c;
            }
        }
        dijkstra(map, dist);
        dijkstra(reverseMap, reverseDist);

        for(int i=1; i<=N; i++){
            if(max < dist[i] + reverseDist[i]){
                max = dist[i]+ reverseDist[i];
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int[][] map, int[] dist) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        //도착점
        dist[X] = 0;
        pq.offer(new Node(X, 0));

        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(n.distance > dist[n.index]) continue;

            for(int i=1; i<=N; i++){
                if(dist[i] > dist[n.index] + map[n.index][i]){
                    dist[i] = dist[n.index] + map[n.index][i];
                    pq.offer(new Node(i, dist[i]));
                }
            }
        }
    }
}
