package com.univers.lib.leetCode;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/13
 *
 * L 165
 */
public class LeetCodeDay23 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.1.3.4","1.1.4"));
        System.out.println(compareVersion("1.1.3.4","1.1.3"));
        System.out.println(compareVersion("1.1.3.4","1.1.3.2"));
        System.out.println(compareVersion("1.1.3.4","1.1.3.4"));
    }

    public static int compareVersion(String v1, String v2) {
        String[] split1 = v1.split("\\.");
        String[] split2 = v2.split("\\.");
        int s1 = split1.length, s2 = split2.length;
        //双指针法
        int start1 = 0, start2 = 0;
        while (start1 < s1 || start2 < s2) {
            int temp1 = 0, temp2 = 0;
            if (start1 < s1) {
                temp1 = Integer.parseInt(split1[start1]);
                start1++;
            }

            if (start2 < s2) {
                temp2 = Integer.parseInt(split2[start2]);
                start2++;
            }

            if (temp1 != temp2) {
                return temp1 > temp2 ? 1 : -1;
            }
        }
        return 0;
    }
}
