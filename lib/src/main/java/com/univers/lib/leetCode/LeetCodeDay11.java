package com.univers.lib.leetCode;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/02
 * 实现 Trie (前缀树)
 */
public class LeetCodeDay11 {

    //前缀树 字典树
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class Trie {
    private boolean isEnd;//是否为结束字符
    private Trie[] next;//下一个字符

    public Trie() {
        isEnd = false;
        //题目提示 仅由小写字母组成
        next = new Trie[26];
    }

    public void insert(String word) {
        Trie cur = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null) {
                cur.next[ch - 'a'] = new Trie();
            }
            cur = cur.next[ch - 'a'];
        }
        //循环结束
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = prefixSearch(word);
        return trie != null && trie.isEnd;
    }

    public boolean startWith(String word) {
        return prefixSearch(word) != null;
    }

    //抽出 共用一个方法 以end做判断
    private Trie prefixSearch(String word) {
        Trie cur = this;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null) {
                return null;
            }
            cur = cur.next[ch - 'a'];
        }
        return cur;
    }
}