package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
 */
public class boj1922 {

    private static int N, E, V;
    private static PriorityQueue<Node> pq;
    private static int[] root;

    public static class Node implements Comparable<Node>{
        int start;
        int end;
        int value;

        Node(int start, int end, int value){
            super();
            this.start = start;
            this.end = end;
            this.value = value;
        }


        @Override
        public int compareTo(Node o) {
            return o.value > value ? -1 : 1;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        pq = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        root = new int[N+1];
        //make root
        for(int i=1; i<=N; i++){
            root[i] = i;
        }

        V = MST();
        bw.write(Integer.toString(V));
        bw.close();
        br.close();
    }

    public static int MST() {
        int value = 0;
        while(!pq.isEmpty()){
            Node n = pq.poll();
            int start = find(n.start);
            int end = find(n.end);

            if(start == end) continue;
            union(start, end);
            value += n.value;
        }
        return value;
    }

    private static int find(int x){
        if(root[x] == x) return x;
        return root[x] = find(root[x]);
    }

    private static void union(int start, int end) {
        start = find(start);
        end = find(end);
        if(start == end) return;
        root[start] = end;
    }
}
