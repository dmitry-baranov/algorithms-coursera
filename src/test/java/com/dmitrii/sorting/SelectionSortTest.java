package com.dmitrii.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void selectionSort() {
        int[] array = new int[]{5, 6, 1, 4, 8, 3, 2, 7};
        int[] result = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        SelectionSort service = new SelectionSort();
        service.selectionSort(array);
        Assertions.assertEquals(array.length, result.length);
        for (int i = 0; i < array.length; i++) {
            Assertions.assertEquals(array[i], result[i]);
        }
    }
}