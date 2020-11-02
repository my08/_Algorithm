package boj;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1039 {
    private static int N, K, max;
    private static boolean[][] visited= new boolean[1000001][11];

    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS();

        bw.write(Integer.toString(max));
        bw.close();
        br.close();

    }
    private static void BFS() {
        Queue<int[]> queue = new LinkedList<>();

        int len = (N+"").length();
        queue.add(new int[]{N, 0});
        visited[N][0] = true;

        while(!queue.isEmpty()) {
            if(queue.peek()[1] == K) break;

            int[] target = queue.poll();
            for(int i=0; i<len-1; i++) {
                for(int j=i+1; j<len; j++) {
                    int swapNum = swap(target[0], i, j);
                    if(swapNum != -1 && !visited[swapNum][target[1]+1]) {
                        visited[swapNum][target[1]+1] = true;
                        queue.add(new int[] {swapNum, target[1]+1});
                    }
                }
            }
        }
        int result = -1;
        while(!queue.isEmpty()) {
            int[] compare = queue.poll();
            if(result < compare[0]) {
                result = compare[0];
            }
        }
        max = result;
    }
    private static int swap(int target, int i, int j) {
        char[] c = Integer.toString(target).toCharArray();

        if(i == 0 && c[j] == '0') {
            return -1;
        }

        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        String str = "";

        for(int n=0; n<c.length; n++) {
            str += c[n] + "";
        }
        return Integer.parseInt(str);
    }

}
