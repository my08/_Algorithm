package boj;

import java.io.*;
import java.util.StringTokenizer;

//
public class boj1018 {
    private static int N, M;
    private static boolean[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }

        bw.write(String.valueOf(chkWrongCell()));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int chkWrongCell() {
        int min = 64;

        for(int a=0; a<=N-8; a++){
            for(int b = 0; b<=M-8; b++){
                int cnt = 0;
                boolean stf = board[a][b];

                for(int i=a; i<8+a; i++) {//행
                    for (int j=b; j <8+b; j++) {//열
                        if(board[i][j] != stf){
                            cnt++;
                        }
                        stf = (!stf);
                    }
                    stf = !stf;
                }
                cnt = Math.min(cnt, 64-cnt);
                min = Math.min(cnt, min);
            }
        }

        return min;
    }

}
