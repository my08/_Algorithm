package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 1≤V≤20,000, 1≤E≤300,000
 * 둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다.
 * 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
 */
/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */
//int로 배열 선언하면 메모리 에러 나니까 ArrayList로 사용
    //LinkedList사용해도 시간초과
public class boj1753 {
    private static int V, E, INF;
    private static List<List<Node>> list;
    private static int[] dist;
    private static PriorityQueue<Node> pq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        dist = new int[V+1];
        INF = 987654321;
        list = new ArrayList<List<Node>>();

        Arrays.fill(dist, INF);

        for(int i=0; i<=V; i++){
            list.add(i, new ArrayList<Node>());
        }

        int startPoint = Integer.parseInt(br.readLine());

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e,c));
        }

        //다익스트라
        Dijkstra(startPoint);
        for(int i=1; i<=V; i++){
            if(dist[i] == INF){
                bw.write("INF" + "\n");
            }else{
                bw.write(String.valueOf(dist[i] + "\n"));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void Dijkstra(int startPoint) {
        boolean[] visited = new boolean[V+1];
        dist[startPoint] = 0;
        pq.add(new Node(startPoint, 0));

        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(visited[n.index]) continue;
            visited[n.index] = true;

            for(Node now : list.get(n.index)){
                if(dist[now.index] > dist[n.index] + now.distance){
                    dist[now.index] = dist[n.index] + now.distance;
                    pq.add(new Node(now.index, dist[now.index]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{

        private int index;
        private int distance;

        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }


        @Override
        public int compareTo(Node o) {
            return o.distance > this.distance ? -1 : 1;
        }
    }
}
