package boj.lca;

public class bit {
    public static void main(String[] args) {
        for(int i=20; i>=0; i--){
            int jump = 1 << i;
            System.out.println(i + " : " + jump);
        }
    }
}
