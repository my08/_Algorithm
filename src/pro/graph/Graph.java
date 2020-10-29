package pro.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int V; //노드의 개수
    private LinkedList<Integer> adj[];  //인접 리스트
    private List<Integer> visitedList = new ArrayList<Integer>();
    //생성자
    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; ++i){ //인접 리스트 초기화
            adj[i] = new LinkedList();
        }
    }

    //노드를 연결 v->w
    void addEdge(int v, int w) { adj[v].add(w); }
    //DFS에 의해 사용되는 함수
    void DFSUtil(int v, boolean[] visited){
        visited[v] = true;//현재 노드를 방문한 것으로 표시하고 값을 출력
        visitedList.add(v);
        System.out.println(v + " ");

        //방문한 노드와 인접한 모든 노드를 가져온다.
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }

    //주어진 노드를 시작으로 DFS 탐색
    void DFS(int v){
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
    //DFS탐색
    List<Integer> DFS(){
        boolean visited[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(visited[i] == false){
                DFSUtil(i, visited);
            }
        }
        return visitedList;
    }

    //BFS
    void BFS(int s){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();

            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }
}
