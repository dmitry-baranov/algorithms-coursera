package com.dmitrii.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    @Test
    void mergeSort() {
        int[] array = new int[]{5, 6, 1, 4, 8, 3, 2, 7};
        int[] result = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        MergeSort service = new MergeSort();
        service.mergeSort(array, array.length);
        Assertions.assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            Assertions.assertEquals(array[i], result[i]);
        }
    }
}