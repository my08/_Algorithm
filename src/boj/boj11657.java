package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11657 {

        private static int N, M, INF;
        private static long[] dist;
        private static Node[] nodes;

        static class Node{
            private int start;
            private int end;
            private int cost;

            Node(int start, int end, int cost){
                super();
                this.start = start;
                this.end = end;
                this.cost = cost;
            }
        }

        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            INF = Integer.MAX_VALUE;
            dist = new long[N+1];
            nodes = new Node[M];

            Arrays.fill(dist, INF);

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                nodes[i] = new Node(s,e,c);
            }

            boolean answer = bellmanFord();
            if(!answer) {
                System.out.println("-1");
            }else {
                for(int i=2; i<=N; i++) {
                    if(dist[i] ==INF) {
                        System.out.println("-1");
                    }else {
                        System.out.println(dist[i]);
                    }
                }
            }
            br.close();
        }

        private static boolean bellmanFord() {

            dist[1] = 0;



            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(dist[nodes[j].start] == INF) continue;
                    if(dist[nodes[j].end] > dist[nodes[j].start] +nodes[j].cost) {
                        dist[nodes[j].end] = dist[nodes[j].start] + nodes[j].cost;
                    }
                }
            }

            boolean cycled = false;

            for(int j=0; j<M; j++) {
                if(dist[nodes[j].start] != INF && (dist[nodes[j].end] > dist[nodes[j].start] +nodes[j].cost)) {
                    cycled = true;
                    break;
                }
            }

            if(cycled) return false;
            return true;
        }
    }
