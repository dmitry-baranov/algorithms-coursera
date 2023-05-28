package com.dmitrii.sorting;

public class QuickSortWithStrategy {

    public long sort(int[] array, int l, int r, PivotStrategy pivotStrategy) {
        if (r - l < 1) {
            return 0;
        }
        long count = 0;

        int pIndex = getPivotIndex(array, l, r, pivotStrategy);
        int npIndex = partition(array, l, r, pIndex);

        count += sort(array, l, npIndex - 1, pivotStrategy);
        count += sort(array, npIndex + 1, r, pivotStrategy);
        return r - l + count;
    }

    private static int partition(int[] array, int l, int r, int pIndex) {
        swap(array, l, pIndex);
        pIndex = l;

        int i = l + 1;
        for (int j = l + 1; j <= r; j++) {
            if (array[j] < array[pIndex]) {
                swap(array, i, j);
                i++;
            }
        }

        swap(array, i - 1, pIndex);
        return i - 1;
    }

    private static int getPivotIndex(int[] array, int l, int r, PivotStrategy pivotStrategy) {
        switch (pivotStrategy) {
            case FIRST -> {
                return l;
            }
            case LAST -> {
                return r;
            }
            case MEDIAN -> {
                int m = l + (int) Math.ceil((r - l + 1) / 2.0) - 1;
                return (array[l] > array[r])
                        ? ((array[r] > array[m]) ? r : ((array[l] > array[m]) ? m : l))
                        : ((array[l] > array[m]) ? l : ((array[r] > array[m]) ? m : r));
            }
            default -> throw new RuntimeException("Unknown pivot strategy");
        }
    }

    private static void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    enum PivotStrategy {
        FIRST, LAST, MEDIAN
    }
}
