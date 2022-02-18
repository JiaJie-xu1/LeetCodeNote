package com.univers.lib.leetCode;

import java.util.Arrays;

/**
 * 快速排序
 */
public class LeetCodeDay31 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 5, 4, 3, 2, 6, 3, 4};
        sortQuickly(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sortQuickly(int[] array, int start, int end) {
        if (start < end) {
            int position = partitionV3(array, start, end);
            sortQuickly(array, start, position - 1);
            sortQuickly(array, position + 1, end);
        }
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
