package boj;

import java.io.*;
import java.util.*;

public class boj1260 {
    private static int N, M, S;
    private static Graph g;
    public static class Graph{
        private int v; //정점
        private LinkedList<Integer> list[]; //인접리스트

        Graph(int s){
            v = s;
            list = new LinkedList[v];
            for(int i=0; i<v; i++){
                list[i] = new LinkedList();
            }
        }

        void addEdge(int s, int t){
            list[s].add(t);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점의 개수(1<=N<=1000)
        M = Integer.parseInt(st.nextToken()); //간선의 개수(1<=M<=10,000)
        S = Integer.parseInt(st.nextToken()); //시작 정점 번호
        g = new Graph(N + 1);
        for(int i=0; i<M; i++){
            String[] str= br.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            g.addEdge(start, to);
            g.addEdge(to, start);
        }

        ArrayList<Integer> dfs = DFS(S);
        ArrayList<Integer> bfs = BFS(S);

        for(Integer e : dfs){
            System.out.print(e + " ");
        }
        System.out.println();
        for(Integer e : bfs){
            System.out.print(e + " ");
        }
    }

    private static ArrayList<Integer> BFS(int s) {
        boolean visited[] = new boolean[N+1];
        visited[s] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>();
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            path.add(s);
            Collections.sort(g.list[s]);
            Iterator<Integer> it = g.list[s].listIterator();

            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return path;
    }

    private static ArrayList<Integer> DFS(int s) {
        boolean visited[] = new boolean[N+1];
        ArrayList<Integer> path = new ArrayList<>();
        return goDFS(s, visited, path);
    }

    private static ArrayList<Integer> goDFS(int s, boolean[] visited, ArrayList<Integer> path) {

        visited[s] = true;
        path.add(s);
        Collections.sort(g.list[s]);
        Iterator<Integer> it = g.list[s].listIterator();

        while(it.hasNext()){
            int n = it.next();
            if(!visited[n]){
                goDFS(n, visited, path);
            }
        }
        return  path;
    }
}
