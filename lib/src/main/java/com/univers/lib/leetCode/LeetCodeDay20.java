package com.univers.lib.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/12
 *
 * 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *  
 *
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmcbym/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class LeetCodeDay20 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 3, 4}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(intersectV2(new int[]{1, 2, 2, 3, 4}, new int[]{2, 3, 5})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] nums3 = new int[Math.min(nums1.length, nums2.length)];
        int i = 0;

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                nums3[i++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOfRange(nums3, 0, i);
    }

    public static int[] intersectV2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int start1 = 0, start2 = 0;
        int end1 = nums1.length, end2 = nums2.length;
        int[] last = new int[Math.min(end1, end2)];
        int i = 0;
        while (start1 < end1 && start2 < end2) {
            if (nums1[start1] > nums2[start2]) {
                start2++;
            } else if (nums1[start1] < nums2[start2]) {
                start1++;
            } else {
                last[i++] = nums1[start1];
                start1++;
                start2++;
            }
        }
        return Arrays.copyOfRange(last, 0, i);
    }
}
