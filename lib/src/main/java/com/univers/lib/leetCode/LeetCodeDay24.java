package com.univers.lib.leetCode;

import java.util.LinkedList;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/13
 *
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa7r55/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCodeDay24 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(4);
        stack.push(-1);
        stack.pop();
        stack.push(0);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    static class MinStack {
        int min = Integer.MAX_VALUE;
        LinkedList<Integer> stack;

        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.pop() == min)
            min = stack.pop();
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return min;
        }
    }
}
