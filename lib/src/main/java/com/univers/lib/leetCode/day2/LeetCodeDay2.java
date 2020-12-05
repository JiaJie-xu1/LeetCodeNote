package com.univers.lib.leetCode.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jay.Xu
 *
 * @since 2020/12/1
 */

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 */
public class LeetCodeDay2 {
    public static void main(String[] args) throws Exception {
        System.out.println(getLongestStr("aubcacsdfhaasdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;

        int[] last = new int[128];
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        //abcabcada
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);//取当前位置字符的ASCII码
            start = Math.max(start, last[index]);//last[index]默认为-1，如果当前的index已经出现过，那么last[index]就会是上次index出现的位置
            end = Math.max(end, i - start);//最终最长字符串的长度，应该取本次长度和本地保存的最长长度中的最大值
            last[index] = i;
            System.out.println("i:" + i + "   index:" + index + "    last[index]:" + last[index] + "     start:" + start + "      end:" + end);
        }

        return end;
    }


    /**
     * 算法复盘
     */
    public static int getLongSubStr(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return str.length();
        }

        int[] last = new int[128];
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {
            int asciiTemp = str.charAt(i);
            start = Math.max(start, last[asciiTemp]);
            maxLength = Math.max(maxLength, i - start + 1);
            last[asciiTemp] = i + 1;
        }
        return maxLength;
    }

    /**
     * 算法第二次复盘
     */
    public static int getLongestStr(String str) {

        if (str.length() == 0 || str.length() == 1) {
            return str.length();
        }

        //记录每个字符上次出现的位置
        int[] last = new int[128];

        int start = 0;//记录最长字符串开始的位置
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);//获取当前字符的ASCII码
            start = Math.max(start, last[c]);
            max = Math.max(max, i - start + 1);
            last[c] = i + 1;
        }
        return max;
    }
}
