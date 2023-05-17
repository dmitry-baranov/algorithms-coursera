package com.dmitrii.countinversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class CountInversionTest {

    @Test
    void countInversion() throws IOException {
        InputStream inputStream = CountInversionTest.class.getResourceAsStream("/ArrayInv.txt");
        int[] array = readFromInputStream(inputStream);
        int[] arrayCopy = Arrays.copyOfRange(array, 0, array.length);
        CountInversion service = new CountInversion();
        Assertions.assertEquals(array[0], 54044);
        Assertions.assertEquals(array[99999], 91901);
        Assertions.assertEquals(array.length, 100000);
        long count = service.mergeSortAndCount(array, 0, array.length - 1);
        System.out.println(count);

        long realCount = CountInversionQuadratic.getInvCount(arrayCopy, array.length);
        System.out.println("Should be: " + realCount);

        Assertions.assertEquals(count,realCount);
    }
    @Test
    void countInversion2(){
        int[] array = {8,4,2,1};
        CountInversion service = new CountInversion();
        long realCount = CountInversionQuadratic.getInvCount(array, array.length);
        System.out.println("Should be: " + realCount);
        Assertions.assertEquals(service.mergeSortAndCount(array, 0, array.length - 1), realCount);
    }
    @Test
    void countInversion3(){
        int[] array = {3,1,2};
        CountInversion service = new CountInversion();
        long realCount = CountInversionQuadratic.getInvCount(array, array.length);
        Assertions.assertEquals(service.mergeSortAndCount(array, 0, array.length - 1), realCount);
    }

    private int[] readFromInputStream(InputStream inputStream)
            throws IOException {
        int[] array = new int[100000];
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