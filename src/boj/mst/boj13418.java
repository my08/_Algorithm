package boj.mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj13418 {

    static int N, M; //정점, 간선
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<Node>(M-1, (n1, n2)-> n1.direction-n2.direction);
        PriorityQueue<Node> revqueue = new PriorityQueue<Node>(M-1, (n1, n2)-> n2.direction-n1.direction);


        for(int i=0; i<M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            queue.add(new Node(start, end, direction));
            revqueue.add(new Node(start, end, direction));
        }

        int q = kruskal(queue); //0
        int rq = kruskal(revqueue);//2

        int answer = Math.abs(q - rq);

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int kruskal(PriorityQueue<Node> queue) {

        int cnt = 0;

        parent = new int[N+1];
        Arrays.fill(parent, -1);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int start = node.start;
            int end = node.end;

            start = find(start);
            end = find(end);

            if(start == end) continue;

            union(start, end);
            if(node.direction == 0) cnt++;

        }

        return cnt * cnt;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(parent[x] < parent[y]) {
            parent[x] += parent[y];
            parent[y] = x;
        }else {
            parent[y] += parent[x];
            parent[x] = y;
        }



    }

    private static int find(int x) {
        if(parent[x] < 0) return x;
        int y = find(parent[x]);
        parent[x] = y;
        return y;
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int direction;

        Node(int start, int end, int direction){
            this.start = start;
            this.end = end;
            this.direction = direction;
        }

        @Override
        public int compareTo(Node o) {
            return this.direction - o.direction;
        }
    }
}

