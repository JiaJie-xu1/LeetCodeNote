package com.univers.lib.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author JayXU
 * @Description 单词搜索Ⅱ
 */
public class LeetCodeDay12 {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{{'a', 'b', 'e'}, {'b', 't', 'a'}, {'b', 'c', 't'}}, new String[]{"aa", "ab", "eat", "ba","ac"}));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, trie, i, j, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    private static void dfs(char[][] board, Trie now, int i, int j, Set<String> ans) {
        if (!now.children.containsKey(board[i][j])) {
            return;
        }
        char ch = board[i][j];
        Trie next = now.children.get(ch);
        if (!"".equals(next.word)) {
            ans.add(next.word);
            next.word = "";
        }
        if (!next.children.isEmpty()) {
            board[i][j] = '#';//避免重复使用
            for (int[] dir : dirs) {
                int i2 = i + dir[0], j2 = j + dir[1];
                if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                    dfs(board, next, i2, j2, ans);
                }
            }
            board[i][j] = ch;
        }

        if (next.children.isEmpty()) {
            now.children.remove(ch);
        }
    }


    static class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            word = "";
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new Trie());
                }
                cur = cur.children.get(ch);
            }
            cur.word = word;
        }
    }
}