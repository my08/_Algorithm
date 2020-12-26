package leetcode.stringAndArray;

import java.util.*;

public class _17_46_GroupAnagrams {
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    /*
    Runtime: 5 ms, faster than 98.83% of Java online submissions for Group Anagrams.
    Memory Usage: 42.1 MB, less than 61.52% of Java online submissions for Group Anagrams.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if(strs == null || strs.length == 0){
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        result.addAll(map.values());
        return result;
    }

}
