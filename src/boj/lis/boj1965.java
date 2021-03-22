package boj.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
8
1 6 2 5 7 3 5 6
 */
public class boj1965 {
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
		int answer1 = LIS1();
		int answer2 = LIS2();
		bw.write(Integer.toString(answer1) + "\n");
		bw.write(Integer.toString(answer2));
		bw.close();
		br.close();
	}
	private static int LIS1() {
		int[] arr = new int[N];
		int length = 1;
		arr[0] = nums[0];
		
		for(int i=1; i<N; i++) {
			if(arr[0] > nums[i]) {
				arr[0] = nums[i];
			}else if(arr[length-1] < nums[i]) {
				arr[length] = nums[i];
				length+=1;
			}else {
				int idx = Arrays.binarySearch(arr, 0, length, nums[i]);
				idx = idx < 0 ? -idx-1 : idx;
				arr[idx] = nums[i];
			}
		}
		
		return length;
		
	}
	private static int LIS2() {
		int[] arr = new int[N];
		int maxLength = 0;
		for(int i=0; i<N; i++) {
			arr[i] = 1;
			for(int j=0; j<i; j++) {
				if(nums[i] > nums[j] && arr[i] < arr[j] + 1) {
					arr[i] = arr[j]+1;
				}
			}
			maxLength = Math.max(maxLength, arr[i]);
		}
		return maxLength;
	}
	
}
