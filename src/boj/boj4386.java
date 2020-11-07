package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj4386 {

    private static int N;
    private static Point p;
    private static PriorityQueue<Point> pq;
    private static ArrayList<Point> list;
    private static int[] root;
    private static double value;

    static class Point implements Comparable<Point>{
        double x;
        double y;
        double cost;
        int px;
        int py;

        Point(double x, double y, double cost){
            super();
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        Point(int px, int py, double cost){
            super();
            this.px = px;
            this.py = py;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost > o.cost ? 1 : -1;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        pq = new PriorityQueue<>();
        root = new int[N];
        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Point(Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken()), 0));
        }
        makeGalaxy();
        MST();
        bw.write(Double.toString(value));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void MST() {
        //make-set
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            int x = find(p.px);
            int y = find(p.py);
            if (x == y) continue;
            union(x, y);
            value += p.cost;
        }
    }
    private static int find(int x) {
        if(root[x] == x){
            return x;
        }else{
            return root[x] = find(root[x]);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return;
        root[x] = y;
    }



    private static void makeGalaxy() {
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                double x = Math.pow(list.get(i).x - list.get(j).x, 2);
                double y = Math.pow(list.get(i).y - list.get(j).y, 2);
                pq.add(new Point(i, j, Math.round(Math.sqrt(x+y)*100)/100.0));
            }
        }
    }
}
