package boj;

/*
2
2
1 2 10
1 2 20
1 2
 */
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1916 {

    private static int E;   //Edge
    private static int V;   //Vertex
    private static PriorityQueue<Node> pq ;
    private static int[] dist;  //거리
    private static int[][] adj; //연결정점 거리
    static class Node implements Comparable<Node> {
        private int index;
        private int cost;
        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        adj = new int[V+1][V+1];

        Arrays.fill(dist, 1000000001);

        pq = new PriorityQueue<>();
        for(int i=0; i<V+1; i++){
            for(int j=0; j<V+1; j++){
                adj[i][j] = 1000000001;
            }
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(adj[s][e] > c){
                adj[s][e] = c;
            }
        }
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());


        pq.add(new Node(from, 0));
        dist[from] = 0;



        dijkstra();
        bw.write(String.valueOf(dist[to]));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra() {
        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(n.cost > dist[n.index]) continue;

            for(int i=1; i<=V; i++){
                if(dist[i] > dist[n.index] + adj[n.index][i]){
                    //i까지의 거리 = 현재까지 거리 + 현재 index에서 i까지
                    dist[i] = dist[n.index] + adj[n.index][i];
                    pq.add(new Node(i, dist[i]));
                }

            }
        }
    }
}
