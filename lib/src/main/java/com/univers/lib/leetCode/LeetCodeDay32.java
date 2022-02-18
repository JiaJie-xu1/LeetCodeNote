package com.univers.lib.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 自己定义一个学生成绩的ArrayList，通过HashMap统计不同分段的学生各有几个人
 * 成绩分段标准：A：90～80 B：80～70 C：70～60 D：60以下
 * 示例：
 * ArrayList = [80, 30, 40, 77, 99, 22, 88]
 * HashMap = {"A"=?, "B"=?, "C"=?}
 */
public class LeetCodeDay32 {

    public static void main(String[] args) {
        sortScore(new int[]{80, 30, 40, 77, 99, 22, 88});
    }

    public static void sortScore(int[] scores) {
        Map<String, Integer> map = new HashMap<>();
        for (int score : scores) {
            if (score < 60) {//D
                if (map.containsKey("D")) {
                    map.put("D", map.get("D") + 1);
                } else {
                    map.put("D", 1);
                }
            } else if (score < 70) {
                if (map.containsKey("C")) {
                    map.put("C", map.get("C") + 1);
                } else {
                    map.put("C", 1);
                }
            } else if (score < 80) {
                if (map.containsKey("B")) {
                    map.put("B", map.get("B") + 1);
                } else {
                    map.put("B", 1);
                }
            } else {
                if (map.containsKey("A")) {
                    map.put("A", map.get("A") + 1);
                } else {
                    map.put("A", 1);
                }
            }
        }

        System.out.println("map:" + map);
    }
}
