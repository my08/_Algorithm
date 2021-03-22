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
10 20 10 30 20 50
 */
public class boj11053 {
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
		
		int length = LIS();
		System.out.println(length);
		
	}
	private static int LIS() {
		int[] arr = new int[N];

		int idx = 1;
		arr[0] = nums[0];
		
		for(int i=1; i<N; i++) {
			if(arr[0] > nums[i]) {
				arr[0] = nums[i];
			}else if(arr[idx-1] < nums[i]) {
				arr[idx] = nums[i];
				idx+=1;
			}else {
				int index = Arrays.binarySearch(nums, 0, idx, nums[i]);
				index = index < 0 ? -index-1 : index;
				arr[index] = nums[i];
			}
		}
		return idx;
	}

}
