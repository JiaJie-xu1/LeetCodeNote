package com.univers.lib.leetCode;

import java.util.Arrays;

/**
 * 有效的字母异位词
 *
 *
 * 两种思路：先排序再比较
 *
 */
public class LeetCodeDay13 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));//
        System.out.println(isAnagram("arc", "acb"));
    }

    /**
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] countArr = new int[26];

        for (int i = 0; i < chars.length; i++) {
            countArr[chars[i] - 'a']++;
            countArr[chart[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (countArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars,chart);
    }
}
