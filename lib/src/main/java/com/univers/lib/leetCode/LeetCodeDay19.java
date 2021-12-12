package com.univers.lib.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/12
 *
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class LeetCodeDay19 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 3, 0, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j;i< nums.length;i++){
            nums[i] = 0;
        }
    }
}