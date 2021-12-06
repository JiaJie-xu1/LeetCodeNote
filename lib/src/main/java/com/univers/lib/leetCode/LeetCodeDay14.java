package com.univers.lib.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 *
 *
 * 两种方案：哈希和数组
 */
public class LeetCodeDay14 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }


    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(s.charAt(i))) {
                map.put(c, -2);
            } else {
                map.put(c, i);
            }
        }
        int min = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -2) {
                min = Math.min(min, entry.getValue());
            }
        }
//
//        int[] temp = new int[26];
//        Arrays.fill(temp, -1);
//        for (int i = 0; i < s.length(); i++) {
//            char t = s.charAt(i);
//            if (temp[t - 'a'] == -1) {
//                temp[t - 'a'] = i;
//            } else {
//                temp[t - 'a'] = -2;
//            }
//        }
//
//        int min = s.length();
//        for (int i = 0; i < 26; i++) {
//            if (temp[i] == -1 || temp[i] == -2) {
//                continue;
//            }
//            min = Math.min(min, temp[i]);
//        }
        return min == s.length() ? -1 : min;
    }
}
