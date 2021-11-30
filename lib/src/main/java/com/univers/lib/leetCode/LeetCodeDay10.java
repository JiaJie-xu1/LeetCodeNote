package com.univers.lib.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jay.Xu
 *
 * @since 2021/11/30
 * 分割回文串
 */
public class LeetCodeDay10 {
    static boolean[][] temp;
    static List<List<String>> ret = new ArrayList<>();
    static List<String> ans = new ArrayList<>();
    static int sum;

    public static void main(String[] args) {
        partition("ssasas");
    }

    public static List<List<String>> partition(String s) {
        sum = s.length();
        temp = new boolean[sum][sum];
        for (int i = 0; i < sum; i++) {
            Arrays.fill(temp[i], true);
        }

        for (int i = sum - 1; i >= 0; --i) {
            for (int j = i + 1; j < sum; ++j) {
                temp[i][j] = temp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        dfs(s, 0);
        return ret;
    }

    private static void dfs(String s, int i) {
        if (i == sum) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < sum; j++) {
            if (temp[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
