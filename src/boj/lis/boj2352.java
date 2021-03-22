package boj.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
6
4 2 6 3 1 5
 */
public class boj2352 {
	static int N;
	static int[] wires;
	static int[] cnts;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		wires = new int[N];
		cnts = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ;i<N; i++) {
			int e = Integer.parseInt(st.nextToken());
			wires[i] = e;
		}
		
		
		int lisResult = LIS();
		
		
		int answer = N - lisResult;
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		br.close();
	}
	private static int LIS() {
		
		cnts[0] = wires[0];
		int length = 1;
		
		for(int i=1; i<N; i++) {
			//후보값이 처음 값보다 적을 때 
			if(cnts[0] > wires[i]) {
				cnts[0] = wires[i];
			}
			//후보값이 마지막값보다 클 때 
			else if(cnts[length-1] < wires[i]) {
				cnts[length] = wires[i];
				length+=1;
			}// 그 외 
			else {
				int idx = Arrays.binarySearch(cnts, 0, length, wires[i]);
				idx = idx <0?-idx-1:idx;
				cnts[idx] = wires[i];
			}
		}
		
		
		return length;
	}
}
