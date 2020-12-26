package leetcode.stringAndArray;

import java.util.ArrayList;
import java.util.List;

public class _16_54_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(solve(matrix));
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
    Memory Usage: 37 MB, less than 78.41% of Java online submissions for Spiral Matrix.
     */
    public static List<Integer> solve(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;

        while(rowStart<=rowEnd && colStart<=colEnd){
            //오른쪽
            for(int i=colStart; i<=colEnd; i++){
                list.add(matrix[rowStart][i]);
            }
            rowStart++;

            //아래쪽
            for(int i=rowStart; i<=rowEnd; i++){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            //왼쪽
            if(rowStart <= rowEnd){
                for(int i=colEnd; i>=colStart; i--){
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            //윗쪽
            if(colStart<=colEnd){
                for(int i=rowEnd; i>=rowStart; i--){
                    list.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return list;
    }
}
