package boj.lca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj3176 {
    static int N, M;
    static int MAX = 100001;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] clist;
    static int[][] parent = new int[MAX][21];
    static int[][] max = new int[MAX][21];
    static int[][] min = new int[MAX][21];
    static int[] depth = new int[MAX];
    static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        clist = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<Integer>();
            clist[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<=N; i++) {
            max[i][0] = 0;
            min[i][0] = Integer.MAX_VALUE;
        }

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);

            clist[a].add(c);
            clist[b].add(c);
        }

        dfs(1, 0);
        parent();

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] answer = getCost(a, b);
            bw.write(Integer.toString(answer[0]) + " " + Integer.toString(answer[1]) + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[] getCost(int a, int b) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        //match level(moving by 2^n)
        for(int i=20; i>=0 ; i--) {
            if(depth[b] - depth[a] >= (1<<i)) {
                maxValue = Math.max(max[b][i], maxValue);
                minValue = Math.min(min[b][i], minValue);
                b = parent[b][i];

            }
        }

        if(a == b) {
            return new int[] {minValue, maxValue};

        }
        //find LCA
        for(int i=20; i>=0; i--) {
            if(parent[a][i] != parent[b][i]) {
                minValue = Math.min(min[a][i],Math.min(minValue, min[b][i]));
                maxValue = Math.max(max[a][i],Math.max(maxValue, max[b][i]));
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        minValue = Math.min(min[a][0],Math.min(minValue, min[b][0]));
        maxValue = Math.max(max[a][0],Math.max(maxValue, max[b][0]));
        return new int[] {minValue, maxValue};
    }

    private static void parent() {
        for(int j=1; j<21; j++) {
            for(int i=1; i<=N; i++) {
                parent[i][j] = parent[parent[i][j-1]][j-1];
                min[i][j] = Math.min(min[i][j-1], min[parent[i][j-1]][j-1]);
                max[i][j] = Math.max(max[i][j-1], max[parent[i][j-1]][j-1]);
            }
        }

    }

    private static void dfs(int here, int level) {
        visited[here] = true;
        depth[here] = level;

        for(int i=0; i<list[here].size(); i++) {
            int next = list[here].get(i);

            if(visited[next]) continue;
            parent[next][0] = here;
            max[next][0] = clist[here].get(i);
            min[next][0] = clist[here].get(i);
            dfs(next, level+1);

        }
    }

}
