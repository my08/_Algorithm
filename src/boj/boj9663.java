package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class boj9663 {

        private static int N;
        private static int[] queenList;
        private static int max;

        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++) {
                queenList = new int[N];
                queenList[0] = i;
                DFS(0, queenList);
            }

            System.out.println(max);

            br.close();
            bw.close();
        }
        private static void DFS(int n, int[] list) {
            if(n == N-1) {
                max++;
            }else {
                for(int i=0; i<N; i++) {
                    queenList[n+1] = i;
                    if(isPossible(n+1,queenList)) {
                        for(int j = 0; j<N; j++) {
                        }
                        DFS(n+1, queenList);
                    }
                }
            }
        }

        private static boolean isPossible(int n, int[] queenList) {
            for(int i=0; i<n;i++) {
                if(queenList[i] == queenList[n]) {
                    return false;
                }
                if(Math.abs(queenList[i]-queenList[n]) == Math.abs(i-n)) { //대각선 존재하면 안됌
                    return false;
                }
            }
            return true;
        }
    }