package leetcode.stringAndArray;

public class _13_53_MaximunSubarray {

    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(maxSubArray(nums));
    }


    public static int maxSubArray(int[] nums) {
//      Runtime: 1 ms, faster than 44.95% of Java online submissions for Maximum Subarray.
//      Memory Usage: 39.1 MB, less than 30.63% of Java online submissions for Maximum Subarray.
        int newSum = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            newSum = Math.max(nums[i], newSum+nums[i]);
            max = Math.max(newSum, max);
        }
        return max;

//      Runtime: 1 ms, faster than 44.95% of Java online submissions for Maximum Subarray.
//      Memory Usage: 38.6 MB, less than 97.60% of Java online submissions for Maximum Subarray.
        /*int[] subSum = new int[nums.length];
        int subMax = nums[0];
        subSum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            subSum[i] = nums[i] + (subSum[i-1] > 0 ? subSum[i-1] : 0);
            subMax = Math.max(subMax, subSum[i]);
        }
        return subMax;*/
    }
}
