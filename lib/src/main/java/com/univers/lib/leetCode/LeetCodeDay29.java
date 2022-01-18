package com.univers.lib.leetCode;

import java.util.Arrays;

/**
 * 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *  
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xaygd7/
 */
public class LeetCodeDay29 {

    public static void main(String[] args) {
        wiggleSort(new int[]{1,2,2,3,5,7});
        wiggleSort(new int[]{1,5,1,1,6,4});
    }

    public static void wiggleSort(int[] nums) {
        int[] help = nums.clone();
        Arrays.sort(help);
        int sum = nums.length;
        for (int i = 1;i< nums.length;i+=2){
            nums[i] = help[--sum];
        }

        for (int i = 0;i<nums.length;i+=2){
            nums[i] = help[--sum];
        }

        System.out.println(Arrays.toString(nums));
    }
}
