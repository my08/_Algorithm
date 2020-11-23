package boj.twoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj2003 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int c = 0;
        int sum = 0;

        while(s < N){
            if(M == sum){
                c++;
                sum -= arr[s];
                s++;
            }else if(M < sum || e > N - 1){
                sum -= arr[s];
                s++;
            }else if(M > sum){
                sum += arr[e];
                e++;
            }
        }

        bw.write(String.valueOf(c));
        bw.close();
        br.close();

    }
}
