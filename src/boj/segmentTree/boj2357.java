package boj.segmentTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
10 4
75
30
100
38
50
51
52
20
81
5
1 10
3 5
6 9
8 10
 */
public class boj2357 {
    static int N, M;
    static int[] nums, minTree, maxTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int h = (int) Math.pow(2, (int) Math.ceil(Math.log(N) / Math.log(2)) + 1);

        //tree = new Point[h];
        minTree = new int[h];
        maxTree = new int[h];
        initMin(1, 1, N);
        initMax(1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            bw.write(Integer.valueOf(findMin(left, right, 1, 1, N)) + " " + Integer.valueOf(findMax(left, right, 1, 1, N)) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int findMax(int left, int right, int idx, int start, int end) {
        if (left > end || right < start) return Integer.MIN_VALUE;
        if (start >= left && end <= right) {
            return maxTree[idx];
        }
        int mid = (start + end) / 2;
        int min1 = findMax(left, right, idx * 2, start, mid);
        int min2 = findMax(left, right, idx * 2 + 1, mid + 1, end);
        return min1 > min2 ? min1 : min2;
    }

    private static int findMin(int left, int right, int idx, int start, int end) {
        if (left > end || right < start) return Integer.MAX_VALUE;
        if (start >= left && end <= right) {
            return minTree[idx];
        }
        int mid = (start + end) / 2;
        int min1 = findMin(left, right, idx * 2, start, mid);
        int min2 = findMin(left, right, idx * 2 + 1, mid + 1, end);
        return min1 > min2 ? min2 : min1;
    }

    private static int initMax(int idx, int start, int end) {
        if (start == end) return maxTree[idx] = nums[start];

        int mid = (start + end) / 2;
        int max1 = initMax(idx * 2, start, mid);
        int max2 = initMax(idx * 2 + 1, mid + 1, end);
        int value = max1 > max2 ? max1 : max2;
        return maxTree[idx] = value;

    }

    private static int initMin(int idx, int start, int end) {
        if (start == end) return minTree[idx] = nums[start];

        int mid = (start + end) / 2;
        int max1 = initMin(idx * 2, start, mid);
        int max2 = initMin(idx * 2 + 1, mid + 1, end);
        int value = max1 < max2 ? max1 : max2;
        return minTree[idx] = value;

    }


}
