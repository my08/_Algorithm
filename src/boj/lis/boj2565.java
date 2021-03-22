package boj.lis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
 */
public class boj2565 {
	static int N;
	static class Node {
		int start;
		int end;
		Node(int start, int end){
			this.start= start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0 ;i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Node(s,e));
		}
		
		Collections.sort(list, (n1,n2)->n1.start-n2.start);
		
		int[] lisResult = lis(list);
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(max, lisResult[i]);
		}
		int answer = N - max;
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static int[] lis(ArrayList<Node> list) {
		int[] lis = new int[list.size()];
		int size = list.size();
		for(int i=0; i<size; i++) {
			lis[i] = 1;
			for(int j=0; j < i; j++) {
				if(list.get(j).end < list.get(i).end) {
					lis[i] = Math.max(lis[i], lis[j]+1);
				}
			}
		}
		return lis;
	}

}
