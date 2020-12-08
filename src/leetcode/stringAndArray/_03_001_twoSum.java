package leetcode.stringAndArray;

import java.util.*;
import java.util.function.Predicate;

public class _03_001_twoSum {
    public static void main(String[] args) {
        int[] nums = {0,4,3,0};
        int target = 0;
        int[] answer = twoSum(nums, target);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] twoSum(int[] nums, int target){

        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
        //Memory Usage: 39.2 MB, less than 54.50% of Java online submissions for Two Sum.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target - nums[i], i);
            }
        }
        return new int[]{0,0};

        //Runtime: 3 ms, faster than 48.88% of Java online submissions for Two Sum.
        //Memory Usage: 39.2 MB, less than 43.73% of Java online submissions for Two Sum.
        /*
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(i, nums[i]);
        }

        for(int i=0; i<list.size(); i++){
            int a = list.get(i);

            if(list.contains(target-a) && list.indexOf(a) != list.lastIndexOf(target-a)){
                return new int[] {i, list.lastIndexOf((int) target-a)};
            }
        }
        return new int[]{0,0};
        */
    }
}
