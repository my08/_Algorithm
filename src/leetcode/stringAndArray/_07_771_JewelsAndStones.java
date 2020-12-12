package leetcode.stringAndArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _07_771_JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbAb";
        System.out.println(solve(J, S));
    }
    public static int solve(String jew, String stone) {

        int cnt = 0;
        //1. Set
//      Runtime: 1 ms, faster than 70.64% of Java online submissions for Jewels and Stones.
//      Memory Usage: 37.5 MB, less than 34.42% of Java online submissions for Jewels and Stones.
        Set<Character> set = new HashSet<>();

        for(char jewel : jew.toCharArray()){
            set.add(jewel);
        }

        for(char stoneChar : stone.toCharArray()){
            if(set.contains(stoneChar)){
                cnt++;
            }
        }

        //2. Map
//      Runtime: 2 ms, faster than 14.52% of Java online submissions for Jewels and Stones.
//      Memory Usage: 37.5 MB, less than 34.42% of Java online submissions for Jewels and Stones.

        /*
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<stone.length(); i++){
            if(!map.containsKey(stone.charAt(i))){
                map.put(stone.charAt(i), 1);
            }else{
                map.put(stone.charAt(i), map.get(stone.charAt(i))+1);
            }
        }

        for(int i=0; i<jew.length(); i++){
            if(map.containsKey(jew.charAt(i))){
                cnt += map.get(jew.charAt(i));
            }
        }
        */

        //3. for
//      Runtime: 0 ms, faster than 100.00% of Java online submissions for Jewels and Stones
//      Memory Usage: 37.5 MB, less than 47.16% of Java online submissions for Jewels and Stones.
        /*
        for(int j=0; j<jew.length(); j++){
            char c = jew.charAt(j);
            for(int i=0; i<stone.length(); i++){
                if(stone.charAt(i) == c){
                    cnt++;
                }
            }
        }
        */
        return cnt;
    }

}
