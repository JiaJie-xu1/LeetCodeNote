package com.univers.lib.leetCode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/15
 * <p>
 * 有序矩阵中第K小的元素
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * You must find a solution with a memory complexity better than O(n2).
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xaicbc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCodeDay26 {

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1, 2}, {1, 3}}, 2));
        System.out.println(kthSmallest(new int[][]{{1}}, 1));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int[] temp = new int[matrix.length * matrix[0].length];

        int i = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                temp[i++] = num;
            }
        }

        Arrays.sort(temp);
        return temp[k - 1];
    }
}
