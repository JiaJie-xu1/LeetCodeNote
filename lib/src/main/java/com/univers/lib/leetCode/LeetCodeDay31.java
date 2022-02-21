package com.univers.lib.leetCode;

import java.util.Arrays;

/**
 * 快速排序
 */
public class LeetCodeDay31 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 5, 4, 3, 2, 6, 3, 4};
        sortQuicklyV2(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sortQuicklyV2(int[] array, int start, int end) {
        if (start < end) {
            //获取中间值的下标
            int position = partitionV5(array, start, end);
            sortQuicklyV2(array, start, position - 1);
            sortQuicklyV2(array, position + 1, end);
        }
    }

    public static int partitionV5(int[] array, int start, int end) {
        int pivot = array[end];
        int point = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[point];
                array[point] = temp;
                point++;
            }
        }
        int temp = array[point];
        array[point] = pivot;
        array[end] = temp;
        return point;
    }

    /**
     * 快排
     *
     * @param array
     * @param start
     * @param end
     */
    public static void sortQuickly(int[] array, int start, int end) {
        if (start < end) {
            //获取中间值的下标（此中间值非真正的中间值）
            int position = partitionV4(array, start, end);
            sortQuickly(array, start, position - 1);
            sortQuickly(array, position + 1, end);
        }
    }


    public static int partitionV4(int[] array, int start, int end) {
        int pivot = array[end];//以最后一个值定为中间值
        int point = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {//小于中间值的都放数组左边
                int temp = array[i];
                array[i] = array[point];
                array[point] = temp;
                point++;
            }
        }
        //交换中间值的位置
        int temp = array[point];
        array[point] = pivot;
        array[end] = temp;
        return point;
    }

    public static int partitionV3(int[] array, int start, int end) {
        int pivot = array[end];
        int point = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[point];
                array[point] = temp;
                point++;
            }
        }
        int temp = array[point];
        array[point] = pivot;
        array[end] = temp;
        return point;
    }

    public static int partitionV2(int[] array, int start, int end) {
        int pivot = array[end];
        int point = start;

        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[point];
                array[point] = temp;
                point++;
            }
        }
        int temp = array[point];
        array[point] = pivot;
        array[end] = temp;
        return point;
    }

    public static int partition(int[] array, int start, int end) {
        //以最后一个数为中间值
        int pivot = array[end];
        int point = start;

        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[point];
                array[point] = temp;
                point++;
            }
            System.out.println(Arrays.toString(array));
        }
        int temp = array[point];
        array[point] = array[end];
        array[end] = temp;
        return point;
    }
}
