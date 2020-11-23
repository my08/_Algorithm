package boj.twoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj1806 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = 0;
        int minLength = Integer.MAX_VALUE;
        int cnt = 0;
        while(start < N){
            if(sum >= S || end > N-1){
                if(sum >= S) {
                    if (minLength > (end - start)) {
                        minLength = end - start;
                    }
                    cnt++;
                }

                sum -= arr[start];
                start++;
            }else{
                sum += arr[end];
                end++;
            }
        }
        if(cnt == 0) bw.write("0");
        else bw.write(String.valueOf(minLength));
        bw.close();
        br.close();
    }
}
