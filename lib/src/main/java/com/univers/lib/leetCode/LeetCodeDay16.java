package com.univers.lib.leetCode;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/6
 *
 * 乘积最大子数组
 *
 * 动态规划
 */
public class LeetCodeDay16 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
        System.out.println(maxProduct(new int[]{-2,3,-4,2}));
    }

    public static int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i] * mn, nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i] * mx, nums[i]));
            ans = Math.max(maxF,ans);
        }
        return ans;
    }
}

