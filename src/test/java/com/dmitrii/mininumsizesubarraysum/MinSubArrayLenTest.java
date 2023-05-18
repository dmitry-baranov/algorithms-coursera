package com.dmitrii.mininumsizesubarraysum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinSubArrayLenTest {

    @Test
    void minSubArrayLen() {
        int[] array = {12,28,83,4,25,26,25,2,25,25,25,12};
        int k = 213;
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        Assertions.assertEquals(7, minSubArrayLen.minSubArrayLen(k,array));
    }
}