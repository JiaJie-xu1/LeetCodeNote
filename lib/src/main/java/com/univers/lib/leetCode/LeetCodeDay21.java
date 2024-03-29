package com.univers.lib.leetCode;

/**
 * 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：任何 i < j < k 的三元组都满足题意
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmb141/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCodeDay21 {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,3,0,7,4}));
    }

    public static boolean increasingTriplet(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;

        for (int three:nums){
            if (three>two) return true;
            if (three <= one) one = three;
            else two = three;
        }
        return false;
    }
}
