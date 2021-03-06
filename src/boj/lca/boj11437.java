package boj.lca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj11437 {
    static int N,M;
    static int MAX = 1000001;
    static int[][] p = new int[MAX][21];
    static int[] d = new int[MAX];
    static boolean [] visited = new boolean[MAX];

    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i = 0;i<arr.length;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i =1;i<N;i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            arr[a].add(b);
            arr[b].add(a);

        }
        M = Integer.parseInt(br.readLine());
        dfs(1,0);
        set_parent();
        for(int i =1;i<=M;i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            bw.write(lca(a,b)+"\n");
        }
        bw.flush();
    }

    static void dfs(int here, int depth) {
        visited[here] = true;
        d[here] = depth;
        for(int next : arr[here]){
            if(visited[next]){
                continue;
            }
            p[next][0] = here;
            dfs(next, depth+1);
        }
    }
    static void set_parent() {
        for (int j = 1; j < 21; j++) {
            for (int i = 1; i <= N; i++) {
                p[i][j] = p[p[i][j - 1]][j - 1];
            }
        }
    }
    static int lca(int a, int b){
        if(d[a] > d[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int n=20;n>=0;n--){
            if(d[b]-d[a] >= (1<<n)){
                b = p[b][n];
            }
        }

        if(a == b) return a;

        for(int n=20;n>=0;n--){
            if(p[a][n] != p[b][n]){
                a = p[a][n];
                b = p[b][n];
            }
        }

        return p[a][0];
    }

}
