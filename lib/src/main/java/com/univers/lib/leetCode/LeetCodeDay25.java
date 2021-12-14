package com.univers.lib.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/14
 *
 * 最大数
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa1401/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCodeDay25 {

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{1,35,53,9,0}));
    }

    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums)
            list.add(num + "");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String res : list) {
            stringBuilder.append(res);
        }

        if (stringBuilder.charAt(0) == '0'){
            return "0";
        }
        return stringBuilder.toString();
    }
}
