package pro.graph.mst;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
7 11
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
/* Union-Find
 * 1. Find : Node x 가 어느 집합에 포함되어 있는지 찾는 연산.
 * 2. Union : Node x가 포함된 집합과 Node y가 포함된 집합을 합치는 연산.
 */
/*
 * 그래프의 간선들을 가중치의 오름차순으로 정렬한다.
 * 정렬된 간선 리스트에서 순서대로 사이클을 형성하지 않는 간선을 선택한다.
 * 	- 가장 낮은 가중치를 먼저 선택한다.
 * 	- 사이클을 형성하는 간선은 제외한다.
 * 해당 간선을 현재의 MST의 집합에 추가한다.
 */
public class Kurskal {
    static int V, E;
    static PriorityQueue<Node> queue;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        queue = new PriorityQueue<Node>(E, (n1, n2)-> (int)(n1.cost-n2.cost));
        parent = new int[V+1];

        for(int i=1;i<=V; i++) {
            parent[i] = -1;
        }

        for(int i=0; i <E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            double cost = Double.parseDouble(st.nextToken());
            queue.add(new Node(start, end, cost));
        }

        double answer = Kruskal();

        bw.write(Integer.toString((int)Math.round(answer)));
        bw.flush();
        bw.close();
        br.close();
    }

    private static double Kruskal() {
        double answer= 0;
        Node tempNode;

        while(!queue.isEmpty()) {
            tempNode = queue.poll();
            int start = tempNode.start;
            int end = tempNode.end;
            double cost = tempNode.cost;

            int s = find(start);
            int e = find(end);

            if(s==e) continue;

            union(start, end);
            answer += cost;
        }
        return answer;
    }

    private static int find(int x) {
        //parent가 음수인 경우, 본인이 root임으로 반
        if(parent[x] < 0) {
            return x;
        }else {
            //한쪽으로만 치우쳐있는 tree구조일 경우, 루트노드를 찾는데 시간이 많이 소요되므로,
            //동일한 루트인 경우 바로 루트노드로 바꿔준다.
            int y = find(parent[x]);
            parent[x] = y;
            return y;
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        //parent[x], parent[y] 값은 음수이므로, 작은 값이 높이가 더 큰 Node이다.
        if(parent[x] < parent[y]) {
            parent[x] += parent[y];
            parent[y] = x;
        }else {
            parent[y] += parent[x];
            parent[x] = y;
        }

    }

    static class Node implements Comparable<Node>{

        int start;
        int end;
        double cost;

        public Node(int start, int end, double cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.cost > o.cost ? 1 : -1;
        }

    }
}