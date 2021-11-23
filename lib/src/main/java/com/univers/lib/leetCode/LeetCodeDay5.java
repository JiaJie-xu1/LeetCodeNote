package com.univers.lib.leetCode;

/**
 * Created by Jay.Xu
 *
 * @since 2021/11/23
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xm0u83/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCodeDay5 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 3};
        int[] nums2 = {1, 2, 2, 3, 3};
        int number = singleNumber(nums);
        int number2 = singleNumber(nums2);
        System.out.println(number);
        System.out.println(number2);
    }

    public static int singleNumber(int[] nums) {
        //知识点：异或
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }
}
