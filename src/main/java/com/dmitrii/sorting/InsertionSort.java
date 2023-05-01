package com.dmitrii.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 1, 4, 8, 3, 2, 7};
        System.out.println("Init array:" + Arrays.toString(array));
        insertionSort(array);
        System.out.println("Result array:" + Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
    }
}
