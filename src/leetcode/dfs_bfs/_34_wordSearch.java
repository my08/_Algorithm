package leetcode.dfs_bfs;

public class _34_wordSearch {
    public static void main(String[] args) {
        _34_wordSearch a = new _34_wordSearch();
        char[][] grid = {{'A', 'B', 'C', 'E'}
                , {'S', 'F', 'C', 'S'}
                , {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        //System.out.println(a.solve(grid, word));
        System.out.println(a.solveLecture(grid, word));
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1}, {0,1}};
    int m, n;
    private boolean solveLecture(char[][] grid, String word) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return false;

        m = grid.length;
        n = grid[0].length;
        boolean[][] visited= new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfsLecture(grid, visited, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsLecture(char[][] grid, boolean[][] visited, int x, int y, int start, String word) {
        if(start==word.length()) return true;
        if(x<0 || y<0 || x>=m || y>=n) return false;
        if(visited[x][y]) return false;
        if(grid[x][y] != word.charAt(start)) return false;

        visited[x][y] = true;

        for(int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            //시작점은 같으나, 나중에 다를 수 있으니 visited 가지고 체크하면서 돌아야한다.
            if (dfsLecture(grid, visited, dx, dy, start + 1, word)) return true;
        }

        visited[x][y] = false;
        return false;
    }

    boolean isResult = false;
    public boolean solve(char[][] grid, String word) {
        char[] chars = word.toCharArray();
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[i].length; j++){
                    if(grid[i][j] == chars[0]){
                        dfs(grid, chars, i, j, 0);
                        return isResult;
                    }
                }
            }
            return isResult;
    }

    private void dfs(char[][] grid, char[] chars, int x, int y, int idx) {
        if(x<0 || y<0 || x>=grid.length || y>=grid[x].length || idx >= chars.length || grid[x][y] != chars[idx]) return;

        grid[x][y] = '-';
        idx++;
        dfs(grid, chars, x-1, y, idx);
        dfs(grid, chars, x+1, y, idx);
        dfs(grid, chars, x, y-1, idx);
        dfs(grid, chars, x, y+1, idx);

        if(idx == chars.length) isResult = true;
        return ;
    }
}
