package boj.segmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj2042 {
    static int N, M, K;
    static int[] nums;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        int size = (int) Math.pow(2, (int) Math.ceil(Math.log(N) / Math.log(2)) + 1);
        tree = new long[size];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        //init
        init(1, 1, N);

        int type, a, b = 0;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (type == 1) {
                nums[a] = b;
                update(1, b - a, a, 1, N);
            } else {
                bw.write(String.valueOf(sum(1, a, b, 1, N)) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static long sum(int node, int left, int right, int start, int end) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(node * 2, left, right, start, mid)
                + sum(node * 2 + 1, left, right, mid + 1, end);
    }

    private static void update(int node, int diff, int a, int start, int end) {
        if (a < start || a > end) {
            return;
        }
        tree[node] += diff;
        if(start != end){
            int mid = (start + end) / 2;
            update(node * 2, diff, a, start, mid);
            update(node * 2 + 1, diff, a, mid + 1, end);

        }
    }

    private static long init(int node, int start, int end) {
        //start == end (leaf)
        if (start == end) return tree[node] = nums[start];

        int mid = (start + end) / 2;
        return tree[node] = init(node * 2, start, mid)
                + init(node * 2 + 1, mid + 1, end);

    }

}
