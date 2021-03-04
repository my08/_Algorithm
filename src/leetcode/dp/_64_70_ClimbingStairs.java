package leetcode.dp;

public class _64_70_ClimbingStairs {
    public static void main(String[] args) {
        _64_70_ClimbingStairs a = new _64_70_ClimbingStairs();
        int n = 4;
        System.out.println(a.climbStairs(n));
    }
    public int climbStairs(int n) {

        //1 or 2 steps
        int[] ways = new int[n+1];
        for(int i=0; i<=n; i++){
            ways[i] = Integer.MAX_VALUE-1;
        }
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;
        for(int i=3; i<=n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }
}
