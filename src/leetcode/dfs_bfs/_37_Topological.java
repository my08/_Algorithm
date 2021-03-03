package leetcode.dfs_bfs;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class _37_Topological {

    public static void main(String[] args) {
        _37_Topological a = new _37_Topological();
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,1},{3,2}};

        System.out.println(a.canFinish(numCourses,prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return false;

        //1. indegree 배열, Queue 생성
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];

        int numsLength = prerequisites.length;
        for(int i=0; i<numsLength; i++){
            indegree[prerequisites[i][1]]++;
        }

        //inDegree == 0인 번호를 찾는다.
        for(int i=0; i< indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int num = queue.poll();

            for(int i=0; i< prerequisites.length; i++){
                if(prerequisites[i][0] == num){
                    indegree[prerequisites[i][1]]--;
                    if(indegree[prerequisites[i][1]] == 0){
                        queue.offer(prerequisites[i][1]);
                    }
                }
            }
        }

        for(int i=0; i< indegree.length; i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
    }

}
