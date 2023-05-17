package com.dmitrii.countinversion;

import java.util.Arrays;

public class CountInversion {
    public long mergeSortAndCount(int[] array, int left, int right) {
        long count = 0;
        if (left == right) {
            return count;
        }
        int middle = (right + left) / 2;
        count += mergeSortAndCount(array, left, middle);
        count += mergeSortAndCount(array, middle + 1, right);
        count += mergeAndCount(array, left, middle, right);

        return count;
    }

    private static long mergeAndCount(int[] arr, int l,
                                      int m, int r) {
        long count = 0;
        int i = 0,j = 0,k = l;
        int[] leftArr = Arrays.copyOfRange(arr, l, m + 1);
        int[] rightArr = Arrays.copyOfRange(arr, m + 1, r + 1);
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] > rightArr[j]) {
                count +=leftArr.length - i;
                arr[k++] = rightArr[j++];
            } else {
                arr[k++] = leftArr[i++];
            }
        }
        while (i < leftArr.length){
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
        return count;
    }
}
