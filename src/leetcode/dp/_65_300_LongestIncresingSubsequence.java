package leetcode.dp;

import java.util.Arrays;

public class _65_300_LongestIncresingSubsequence {
    public static void main(String[] args) {
        _65_300_LongestIncresingSubsequence a = new _65_300_LongestIncresingSubsequence();
        int[] nums = {0,1,0,3,2,3};
        System.out.println(a.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        int result = 1;

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
