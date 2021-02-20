package leetcode.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

// 1: land, 0 : water
public class _27_numberOfIsland {


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        //System.out.println(numIslandsDFS(grid));
        System.out.println(numIslandsBFS(grid));
    }

    private static int numIslandsBFS(char[][] grid) {
        if(grid==null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;

        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;

    }

    static int[][] dirs = {{-1, 0},{1,0},{0,1},{0,-1}};
    //bfs는 queue를 써라
    private static void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            int size = queue.size();
            int[] point = queue.poll();
            for(int i=0; i<size; i++){
                for(int[] dir: dirs){
                    int x1 = point[0] + dir[0];
                    int y1 = point[1] + dir[1];
                    if(x1>=0 && y1>=0 && x1<grid.length && y1<grid[0].length && grid[x1][y1] == '1'){
                        System.out.println("================================queue================================");
                        for(int a=0; a<grid.length; a++){
                            for(int b=0; b<grid[a].length; b++){
                                System.out.print(grid[a][b] + " ");
                            }
                            System.out.println();
                        }
                        grid[x1][y1] = '0';
                        queue.offer(new int[]{x1,y1});

                    }
                }
            }
        }
    }

    public static int numIslandsDFS(char[][] grid) {

        if(grid==null || grid.length == 0|| grid[0].length == 0){
            return 0;
        }
        int count = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;

    }

    private static void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>=m||j<0||j>=n||grid[i][j]!='1')return;

        grid[i][j]='X';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }


}
