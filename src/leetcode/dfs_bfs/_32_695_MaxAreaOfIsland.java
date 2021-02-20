package leetcode.dfs_bfs;


public class _32_695_MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{1}};
        //System.out.println("ANSWER : " + maxAreaOfIsland(grid));
        _32_695_MaxAreaOfIsland a = new _32_695_MaxAreaOfIsland();
        System.out.println("ANSWER : " + a.maxAreaOfIsland_Lecture(grid));
    }

    int m, n;
    int[][] dirs = {{-1,0}, {1,0},{0,-1},{0,1}};
    private int maxAreaOfIsland_Lecture(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;

        int max = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j,0);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int x, int y, int area) {
        //1. 탈출조건
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) return area;

        //2. 육지인 경우
        grid[x][y] = 0;
        area++;
        for(int[] dir : dirs){
            area = dfs(grid, x+dir[0], y+dir[1], area);
        }
        return area;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int MAX_AREA = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    int AREA = sumArea(grid, i, j, 0);
                    MAX_AREA = Math.max(MAX_AREA, AREA);
                    //System.out.println(MAX_AREA);
                }
            }
        }
        return MAX_AREA;
    }

    private static void print(int[][] grid) {
        System.out.println("==============================print=================================");
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*
    Runtime: 3 ms, faster than 50.22% of Java online submissions for Max Area of Island.
    Memory Usage: 44.4 MB, less than 12.19% of Java online submissions for Max Area of Island.
     */
    private static int sumArea(int[][] grid, int i, int j, int cnt) {
        if(i<0 || j<0 || i>= grid.length || j>= grid[i].length||grid[i][j]!=1) return cnt;

//        print(grid);

        //make matrix to '0'
        grid[i][j] = 0;
        cnt++;

        cnt = sumArea(grid, i-1, j, cnt);
        cnt = sumArea(grid, i+1, j, cnt);
        cnt = sumArea(grid, i, j-1, cnt);
        cnt = sumArea(grid, i, j+1, cnt);

        return cnt;
    }

}
