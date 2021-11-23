package com.univers.lib.leetCode.day4;

/**
 * Created by Jay.Xu
 *
 * @since 2020/12/29
 */
public class LeetCodeDay4 {
    public static void main(String[] args) {
        int[] arr = {6, 1, 3, 2, 5, 4, 9, 0, 7};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {

        //数组最左边小于最右边不合法,直接退出
        if (left > right) {
            return;
        }

        //定义变量i指向最左边
        int i = left;

        //定义变量j指向最右边
        int j = right;

        //定义左边为基准元素base
        int base = arr[left];

        //只要i和j没有指向同一个元素,就继续交换
        while (i != j) {

            //从右向左寻找第一个小于基准元素的数
            while (arr[j] >= base && i < j) {
                j--;
            }
            System.out.println("j-----> " + j);

            //从左向右寻找第一个大于基准元素的数
            while (arr[i] <= base && i < j) {
                i++;
            }
            //执行到这里证明找到了i和j指向的元素
            //交换i和j指向的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //将i和j共同指向的元素与基准元素交换
        arr[left] = arr[i];
        arr[i] = base;


        //对左边进行快速排序
        quickSort(arr, left, i - 1);

        //对右边进行快速排序
        quickSort(arr, i + 1, right);

    }

    public static void sort(int[] arr, int left, int right) {
        //数组最左边小于最右边不合法,直接退出
        if (left > right) {
            return;
        }

        int i = left;
        int j = right;

        int base = arr[left];

        while (i != j) {
            while (i < j && arr[j] >= base) {
                j--;
            }

            while (i < j && arr[i] <= base) {
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[left] = arr[i];
        arr[i] = base;

        sort(arr, left, i - 1);

        sort(arr, i + 1, right);
    }
}
