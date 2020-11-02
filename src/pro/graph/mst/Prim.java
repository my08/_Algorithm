package pro.graph.mst;

import javafx.scene.layout.Priority;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 정점 중 아무 시작 정점을 고른다.
2. 해당 정점에 연결된 모든 간선 중 가장 최소비용을 가진 간선을 선택 후 연결한다.
3. 처음~선택된 간선에 연결된 정점까지 모든 연결된 정점에 연결된 간선 중 가장 비용이 적은 간선을 연결한다.
4. 모든 정점이 연결될 때 까지 2,3번 반
*/
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
class Node{
    int s, e, v;
    public Node(int s, int e, int v){
        super();
        this.s = s; //start
        this.e = e; //end
        this.v = v; //value
    }
}
public class Prim {
    static int N;
    static int E;
    static ArrayList<Node>[] nodeList;
    static boolean visited[];
    static int answer;
    static ArrayList<Node> array = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        N = Integer.parseInt(br.readLine());    //정점
        E = Integer.parseInt(br.readLine());    //간선

        visited = new boolean[N+1];

        nodeList = new ArrayList[N+1];          //각 노드의 연결상태를 저장
        for(int i=1; i<=N; i++){
            nodeList[i] = new ArrayList<Node>();
        }

        int start = 0;
        int end = 0;
        int value = 0;

        StringTokenizer st;

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            nodeList[start].add(new Node(start,end,value));
            nodeList[end].add(new Node(end,start,value));
        }
        
        MST();
        System.out.println(answer);
    }

    private static void MST() {
        Compare cp = new Compare();
        PriorityQueue<Node> pq = new PriorityQueue<>(cp); //비용 간선
        Deque<Integer> dq = new ArrayDeque<>(); //방문 큐
        dq.add(1);

        ArrayList<Node> tempList;
        Node tempNode;
        while(!dq.isEmpty()){
            int currentNode = dq.poll();
            visited[currentNode] = true;
            tempList = nodeList[currentNode];
            for(int i=0; i<tempList.size(); i++){
                if(!visited[tempList.get(i).e]){
                    pq.add(tempList.get(i));
                }
            }

            while(!pq.isEmpty()){
                tempNode = pq.poll();
                if(!visited[tempNode.e]){
                    visited[tempNode.e] = true;
                    answer += tempNode.v;
                    dq.add(tempNode.e);
                    break;
                }
            }
        }
    }

    private static class Compare implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.v > o2.v ? 1 : -1;
        }
    }
}
