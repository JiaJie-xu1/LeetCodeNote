package com.univers.lib.leetCode;

import java.util.Arrays;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/16
 *
 * 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCodeDay28 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }

    /**
     * 时间复杂度过高导致超时
     * TODO 后面看看LeetCode怎么优化
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;

        int start = 0;
        int[] res = new int[nums.length - k + 1];
        while (start < nums.length - k + 1) {
            int max = Integer.MIN_VALUE;
            for (int i = 0;i < k;i++){
                max = Math.max(max, nums[start + i]);
            }
            res[start++] = max;
        }
        return res;
    }
}
