package leetcode.stringAndArray;

import java.util.ArrayList;
import java.util.List;

public class _20_163_MissingRanges {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 50, 75};
        int lower = 0, upper = 99;
        System.out.println(solve(nums, lower, upper)); //[0->1, 4, 6->49, 51->74, 76->99]
    }

    private static List<String> solve(int[] nums, int lower, int upper) {

        List<String> result = new ArrayList<>();
        if(nums == null || nums.length==0)
            return result;

        //idx == 0
        if(lower < nums[0]){
            result.add(makeRange(lower, nums[0]-1));
        }
        //0 < idx < length-1
        for(int i=0; i< nums.length-1; i++){
            if(nums[i] != nums[i+1] && nums[i]+1<nums[i+1]){
                result.add(makeRange(nums[i]+1, nums[i+1]-1));
            }
        }
        //idx == length -1
        if(nums[nums.length-1] < upper){
            result.add(makeRange(nums[nums.length-1]+1, upper));
        }
        return result;
    }

    private static String makeRange(int low, int high) {
        return low == high ? String.valueOf(low) : low + "->" + high;

    }

    public static List<String> solveMine(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();

        if(nums[0] != lower){
            int gap = nums[0];
            if(gap == 1){
                list.add(lower+"");
            }else{
                list.add(lower+"->"+(gap-1));
            }
        }
        for(int i=2; i<= nums.length-1; i++){
            int gap = nums[i] - nums[i-1];
            if(gap >= 2){
                if(gap == 2){
                    list.add(nums[i-1]+1+"");
                }else{
                    list.add((nums[i-1]+1) +"->" + (nums[i]-1));
                }
            }
        }

        if(nums[nums.length-1] != upper){
            int gap = upper - nums[nums.length-1];
            if(gap == 1){
                list.add(upper+"");
            }else{
                list.add(nums[nums.length-1]+1+"->"+upper);
            }
        }
        return list;
    }
}
