package leetcode.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _36_Maze {
    public static void main(String[] args) {
        _36_Maze a = new _36_Maze();

        int[][] maze = {{0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};

        int[] start = {0, 4};
        int[] destination = {4, 4};
        //System.out.println(a.hasPath_dfs(maze, start, destination));
        // System.out.println(a.hasPath_dfs_lecture(maze, start, destination));
        System.out.println(a.hasPath_bfs(maze, start, destination));
        System.out.println(a.hasPath_bfs_lecture(maze, start, destination));
    }


    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n; //가로, 세로 길이


    private boolean hasPath_bfs_lecture(int[][] maze, int[] start, int[] destination) {

        m = maze.length;
        n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) { //갈 수 있는 방향인 경우 동일 방향 가능한 부분 까지 함께 넣어준다.
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (visited[x][y]) continue;
                visited[x][y] = true;
                if (x == destination[0] && y == destination[1]) return true;
                queue.offer(new int[]{x, y});
            }
        }
        return false;
    }


    private boolean hasPath_bfs(int[][] maze, int[] start, int[] destination) {

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        boolean hasRoute = false;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            visited[point[0]][point[1]] = true;

            if (point[0] == destination[0] && point[1] == destination[1]) {
                hasRoute = true;
                break;
            }

            for (int[] dir : dirs) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];

                if (!(x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] != 0 || visited[x][y])) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return hasRoute;

    }


    private boolean hasPath_dfs_lecture(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;

        m = maze.length;
        n = maze[0].length;

        boolean[][] visited = new boolean[m][n];

        return dfs_lecVer(maze, start, destination, visited);

    }

    private boolean dfs_lecVer(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (start[0] < 0 || start[1] < 0 || start[0] >= m || start[1] >= n || visited[start[0]][start[1]]) {
            return false;
        }

        visited[start[0]][start[1]] = true;

        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];

            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                x += dir[0];
                y += dir[1];
            }

            //벽면 인식 후
            x -= dir[0];
            y -= dir[1];

            if (dfs_lecVer(maze, new int[]{x, y}, destination, visited)) {
                return true;
            }
            ;
        }

        return false;
    }

    public boolean hasPath_dfs(int[][] maze, int[] start, int[] destination) {

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], destination);
    }

    boolean hasRoute = false;

    private boolean dfs(int[][] maze, int i, int j, int[] destination) {

        if (i < 0 || j < 0 || i >= maze.length || j >= maze[i].length || maze[i][j] != 0) {
            return false;
        }

        if (i == destination[0] && j == destination[1]) {
            hasRoute = true;
            return true;
        }

        maze[i][j] = 2;

        dfs(maze, i + 1, j, destination);
        dfs(maze, i - 1, j, destination);
        dfs(maze, i, j + 1, destination);
        dfs(maze, i, j - 1, destination);

        return hasRoute;
    }
}
