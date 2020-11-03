package pro.graph.mst;

public class Node implements Comparable<Node>{
        int start;
        int end;
        int value;

        Node(int start, int end, int value){
            super();
            this.start = start;
            this.end = end;
            this.value = value;
        }

    @Override
    public int compareTo(Node o) {
        return o.value > value ? -1 : 1;
    }
}

