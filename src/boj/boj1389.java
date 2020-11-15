package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
첫째 줄에 유저의 수 N (2 ≤ N ≤ 100)과 친구 관계의 수 M (1 ≤ M ≤ 5,000)이 주어진다.
둘째 줄부터 M개의 줄에는 친구 관계가 주어진다.
친구 관계는 A와 B로 이루어져 있으며, A와 B가 친구라는 뜻이다.
A와 B가 친구이면, B와 A도 친구이며, A와 B가 같은 경우는 없다.
친구 관계는 중복되어 들어올 수도 있으며, 친구가 한 명도 없는 사람은 없다.
또, 모든 사람은 친구 관계로 연결되어져 있다.
사람의 번호는 1부터 N까지이며, 두 사람이 같은 번호를 갖는 경우는 없다.

5 5
1 3
1 4
4 5
4 3
3 2
*/
public class boj1389 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N+1][N+1];
        int INF = 100 * 5000;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j) matrix[i][j] = 0;
                matrix[i][j] = INF;
            }
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        for(int k=1; k<=N; k++){ //경유
            for(int i=1; i<=N; i++){ //출발
                for(int j=1; j<=N; j++){ //도착
                    if(matrix[i][j] > matrix[i][k] + matrix[k][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        //가장 작은 KB수 구하기
        int min = INF;
        int minFriend = 0;

        for(int i=1; i<=N; i++){
            int sum = 0;
            for(int j=1; j<=N; j++){
                sum += matrix[i][j];
            }

            if(min > sum || (min == sum && minFriend > i)){
                min = sum;
                minFriend = i;
            }
        }

        bw.write(String.valueOf(minFriend));
        bw.flush();
        br.close();
        br.close();
    }

}
