package com.dmitrii.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinSubArrayLenTest {

    @Test
    void sortColors() {
        int[] array = {2,0,2,1,1,0};
        int[] arrayCopy = {2,0,2,1,1,0};
        Solution solution = new Solution();
        solution.sortColors(array);
        for (int i = 0; i< arrayCopy.length; i++){
            Assertions.assertEquals(array[i], arrayCopy[i]);
        }

    }
}