package pro.graph.mst;

import javafx.scene.layout.Priority;

import java.io.*;
import java.util.*;

/*
1. 정점 중 아무 시작 정점을 고른다.
2. 해당 정점에 연결된 모든 간선 중 가장 최소비용을 가진 간선을 선택 후 연결한다.
3. 처음~선택된 간선에 연결된 정점까지 모든 연결된 정점에 연결된 간선 중 가장 비용이 적은 간선을 연결한다.
4. 모든 정점이 연결될 때 까지 2,3번 반
(시작 정점만 MST 집합으로 포함됨.
MST집합에 인접한 정점 중 최소비용인 간선 선택(가중치 최저 선택)
트리가 N-1개의 간선을 가질 때 까지 반복)
*/
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

public class Prim {
    static int V, E;
    static boolean[] visited;
    static ArrayList<Node>[] nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[V+1];
        visited = new boolean[V+1];

        for(int i=1; i<=V; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for(int i=0; i <E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            double cost = Double.parseDouble(st.nextToken());
            nodeList[start].add(new Node(start, end, cost));
            nodeList[end].add(new Node(end, start, cost));
        }

        double answer = Prim();

        bw.write(Integer.toString((int)Math.round(answer)));
        bw.flush();
        bw.close();
        br.close();

    }

    static double Prim() {
        Queue<Node> queue = new PriorityQueue<Node>();
        Queue<Integer> numQueue = new LinkedList<>();
        double answer = 0;
        numQueue.add(1);

        while(!numQueue.isEmpty()) {
            int num = numQueue.poll();
            visited[num] = true;

            for(int i=0; i<nodeList[num].size(); i++) {
                if(!visited[nodeList[num].get(i).end]) { //도착지 방문 안했다면
                    queue.add(nodeList[num].get(i));
                }
            }

            while(!queue.isEmpty()) {
                Node node = queue.poll();
                if(!visited[node.end]) {
                    visited[node.end] = true;
                    answer += node.cost;
                    numQueue.add(node.end);
                    break;
                }
            }

        }

        return answer;

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
