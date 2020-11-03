package pro.graph.mst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
7
11
1 2 2
2 3 5
1 3 20
1 4 10
4 5 1
5 6 23
3 6 3
3 5 6
7 6 9
7 3 2
2 7 7
 */
public class Kurskal {
    private static int N, E, V;
    private static int[] root;
    private static PriorityQueue<Node> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());    //노드
        E = Integer.parseInt(br.readLine());    //간선

        pq = new PriorityQueue<Node>();
        root = new int[N+1];
        for(int i=1; i<N+1; i++){
            root[i] = i;
        }
        StringTokenizer st;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            Node n = new Node(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            pq.add(n);
        }

        MST();
        System.out.println(V);
    }

    private static void MST() {

        while(!pq.isEmpty()){
            Node n = pq.poll();

            int start = find(n.start);
            int end = find(n.end);
            if(start == end) continue;
            union(start, end);
            V += n.value;
        }
    }

    private static void union(int start, int end) {

        start = find(start);
        end = find(end);
        if(start == end) return;
        root[start] = end;
    }

    private static int find(int start) {
        if(root[start] == start) return start;
        return root[start] = find(root[start]);
    }
}