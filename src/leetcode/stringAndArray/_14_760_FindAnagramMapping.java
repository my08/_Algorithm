package leetcode.stringAndArray;

import java.util.*;

//int[] A = {11, 27, 45, 31, 50};
//int[] B = {50, 11, 31, 45, 27};
//Output : [1 4 3 2 0 ]
public class _14_760_FindAnagramMapping {
    public static void main(String[] args) {
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
//        Output : [1 4 3 2 0 ]
//        int[] answer = anagramMappingsMine(A, B);
        int[] answer = anagramMappings(A, B);
        for(int i : answer){
            System.out.println(i);
        }
    }

    private static int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<A.length; i++){
            map.put(B[i], i);
        }
        for(int i=0; i<A.length; i++){
            result[i] = map.get(A[i]);
        }
        return result;
    }

    public static int[] anagramMappingsMine(int[] A, int[] B) {
        int[] answer = new int[A.length];
        Queue<Integer> q = new LinkedList<Integer>();

        for(Integer i : A){
            q.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i : B){
            list.add(i);
        }
        //List<Integer> list = new ArrayList(Arrays.asList(A));
        int idx = 0;
        while(!q.isEmpty()){
            int number = q.poll();
            answer[idx++] = list.indexOf(number);
        }

        return answer;
    }

}
