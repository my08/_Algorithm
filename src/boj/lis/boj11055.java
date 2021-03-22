package boj.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
10
1 100 2 50 60 3 5 6 7 8
 */
public class boj11055 {
	
	static int N;
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}	
		int answer = LIS();
		bw.write(Integer.toString(answer));
		bw.close();
		br.close();
	}
	private static int LIS() {
		int[] arr = new int[N];
		
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			arr[i] = nums[i];
			for(int j=0; j<i; j++) {
				if(nums[i] > nums[j] && arr[i] < nums[i]+arr[j]) {
					arr[i] = nums[i] + arr[j];
				}
			}
			max = Math.max(max, arr[i]);
		}
		
		return max;
	}
}
