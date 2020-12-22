package com.univers.lib.leetCode.day3;

/**
 * Created by Jay.Xu
 *
 * @since 2020/12/1
 */

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class LeetCodeDay3 {
    public static void main(String[] args) throws Exception {
//        System.out.println(isValid2("({[]})"));
        testThread();
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.length() == 0;
    }

    public static boolean isValid2(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        //({[]})
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        if (stack.empty())
            return true;
        return false;
    }

    /**
     * 算法第二次复盘，该题完美的切合了栈的先进后出，使用栈很容易实现
     */
    public static boolean isValid3(String str) {
        if (str.isEmpty())
            return true;

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }
            if (c == '[') {
                stack.push(']');
            }
            if (c == '{') {
                stack.push('}');
            }
            if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void testThread() {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("t1   :" + Thread.currentThread() + ":" + i);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("t2   :" + Thread.currentThread() + ":" + i);
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("t3   :" + Thread.currentThread() + ":" + i);
                }
            }
        };
        try {
            t3.start();
            t3.join();

            t2.start();
            t2.join();

            t1.start();
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
