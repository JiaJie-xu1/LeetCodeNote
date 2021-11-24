package com.univers.lib.leetCode;

/**
 * Created by Jay.Xu
 *
 * @since 2021/11/24
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xmlwi1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCodeDay7 {

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println("serarch:"+searchMatrix(matrix,25));
        System.out.println("serarch:"+searchMatrix(matrix,14));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;
        int row = matrix.length - 1;
        while (col < matrix[0].length && row > 0) {
            if (target > matrix[row][col]){
                col ++;
            }else if (target < matrix[row][row]){
                row --;
            }else {
                return true;
            }
        }
        return false;
    }
}
