package leetcode.dp;

public class _62_UniquePaths {
    public static void main(String[] args) {

        _62_UniquePaths a = new _62_UniquePaths();
        int m = 3;
        int n = 7;

        System.out.println(a.uniquePaths(m, n));
    }
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];

        for(int i=0; i<m; i++){
            map[i][0] = 1;
        }

        for(int i=0; i<n; i++){
            map[0][i] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }

        return map[m-1][n-1];
    }
}
