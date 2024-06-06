package com.leetcode.dataStructure;

public class MaximumSubarray {
    public static int[] prefixSum(int[] nums) {
        int len = nums.length;
        //dp[i]表示前i项的和
        int[] dp = new int[len];
        //边界条件
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            //状态转移方程
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(prefixSum(nums));
    }
}
