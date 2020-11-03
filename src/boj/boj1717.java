package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
public class boj1717 {
    private static int N, M;
    private static int root[];
    private static Queue<Point> q;

    static class Point{
        int start;
        int end;
        Point(int start, int end){
            super();
            this.start = start;
            this.end = end;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();



        root = new int[N+1];
        //make root
        for(int i=1; i<N+1; i++){
            root[i] = i;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 0){
                q.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }else{
                String isConnected = MST(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                bw.write(isConnected + "\n");
            }
        }
        bw.close();
        br.close();
    }

    private static String MST(int a, int b) {
        while(!q.isEmpty()){
            Point p = q.poll();
            int p1 = find(p.start);
            int p2 = find(p.end);
            if(p1 == p2) continue;
            union(p1, p2);
        }
        if(find(a) == find(b)){
            return "YES";
        }
        return "NO";
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return;
        root[a] = b;

    }

    private static int find(int a) {
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
