package com.univers.lib.leetCode;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/10
 * <p>
 * 旋转数组
 */
public class LeetCodeDay17 {

    public static void main(String[] args) {

    }

    public static void rotation(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
