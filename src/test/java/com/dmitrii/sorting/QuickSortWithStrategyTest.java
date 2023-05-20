package com.dmitrii.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class QuickSortWithStrategyTest {

    @Test
    void sortByFirstElement() throws IOException {
        InputStream inputStream = QuickSortFirstElementTest.class.getResourceAsStream("/QuickSortInput.txt");
        int[] array = readFromInputStream(inputStream);
        QuickSortWithStrategy service = new QuickSortWithStrategy();
        Assertions.assertEquals(array[0], 2148);
        Assertions.assertEquals(array[9999], 9269);
        Assertions.assertEquals(array.length, 10000);
        long count = service.sort(array, 0, array.length - 1, QuickSortWithStrategy.PivotStrategy.FIRST);

        System.out.println("Answer: " + count);
    }

    @Test
    void sortByLastElement() throws IOException {
        InputStream inputStream = QuickSortFirstElementTest.class.getResourceAsStream("/QuickSortInput.txt");
        int[] array = readFromInputStream(inputStream);
        QuickSortWithStrategy service = new QuickSortWithStrategy();
        Assertions.assertEquals(array[0], 2148);
        Assertions.assertEquals(array[9999], 9269);
        Assertions.assertEquals(array.length, 10000);
        long count = service.sort(array, 0, array.length - 1, QuickSortWithStrategy.PivotStrategy.LAST);

        System.out.println("Answer: " + count);
    }

    @Test
    void sortByMedianElement() throws IOException {
        InputStream inputStream = QuickSortFirstElementTest.class.getResourceAsStream("/QuickSortInput.txt");
        int[] array = readFromInputStream(inputStream);
        QuickSortWithStrategy service = new QuickSortWithStrategy();
        Assertions.assertEquals(array[0], 2148);
        Assertions.assertEquals(array[9999], 9269);
        Assertions.assertEquals(array.length, 10000);
        long count = service.sort(array, 0, array.length - 1, QuickSortWithStrategy.PivotStrategy.MEDIAN);

        System.out.println("Answer: " + count);
    }

    private static int[] readFromInputStream(InputStream inputStream)
            throws IOException {
        int[] array = new int[10000];
        int i = 0;
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                array[i++] = Integer.parseInt(line);
            }
        }
        return array;
    }
}