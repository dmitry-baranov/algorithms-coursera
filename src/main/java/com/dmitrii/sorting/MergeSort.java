package com.dmitrii.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 1, 4, 8, 3, 2, 7};
        System.out.println("Init array:" + Arrays.toString(array));
        mergeSort(array, array.length);
        System.out.println("Result array:" + Arrays.toString(array));
    }

    /*
    Merge sort (Recursive method)
     */
    public static void mergeSort(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        /*
        for (int i = 0; i < mid; i++) {
            leftArr[i] = array[i];
        }
         */
        System.arraycopy(array, 0, leftArr, 0, mid);

        /*
        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = array[i];
        }
         */
        System.arraycopy(array, mid, rightArr, 0, n - mid);
        mergeSort(leftArr, leftArr.length);
        mergeSort(rightArr, rightArr.length);

        merge(array, leftArr, rightArr, leftArr.length, rightArr.length);
    }

    private static void merge(int[] array, int[] leftArr, int[] rightArr, int rLength, int lLength) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < lLength && j < rLength) {
            if (leftArr[i] <= rightArr[j]) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }
        while (i < lLength) {
            array[k++] = leftArr[i++];
        }
        while (j < rLength) {
            array[k++] = rightArr[j++];
        }
    }


}
