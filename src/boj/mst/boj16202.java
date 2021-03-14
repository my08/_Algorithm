package boj.mst;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
6 9 6
1 2
2 3
3 4
4 5
5 6
1 6
1 4
2 5
3 6
 */
public class boj16202 {static int N, M, K; //정점, 간선, 턴의 수

    static int[] parent;
    static ArrayList<Node> list;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = new ArrayList<Integer>();

        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Node(start, end, i));
        }

        for(int i=0; i<K; i++) {
            kruskal(new PriorityQueue<Node>(queue), i);

        }
        for(int i=0; i<K; i++) {
            bw.write(Integer.toString(answer.get(i))+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void kruskal(PriorityQueue<Node> queue, int i) {
        list = new ArrayList<Node>();
        parent = new int[N+1];
        for(int j=1; j<=N; j++) {
            parent[j] = -1;
        }
        int cost = 0;
        int cnt = 0;
        int k = i;

        while(!queue.isEmpty()) {
            while(k>0) {
                k--;
                queue.poll();
            }

            Node node = queue.poll();

            int start = node.start;
            int end = node.end;

            start = find(start);
            end = find(end);

            if(start == end) continue;

            union(start, end);
            cost += node.cost;
            cnt++;

        }

        if(cnt == N-1) {
            answer.add(cost);
        }else {
            answer.add(0);
        }

    }

    private static void union(int start, int end) {

        start = find(start);
        end = find(end);

        if(start == end) return;

        if(parent[start] < parent[end]) {
            parent[start] += parent[end];
            parent[end] = start;
        }else {
            parent[end] += parent[start];
            parent[start] = end;
        }
    }

    private static int find(int start) {
        if(parent[start] < 0) return start;

        int y = find(parent[start]);
        parent[start] = y;
        return y;
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;

        Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}