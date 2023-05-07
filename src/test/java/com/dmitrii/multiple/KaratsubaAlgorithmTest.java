package com.dmitrii.multiple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class KaratsubaAlgorithmTest {

    @Test
    void karatsubaAlgorithm() {
        String firstNumber = "3141592653589793238462643383279502884197169399375105820974944592";
        String secondNumber = "2718281828459045235360287471352662497757247093699959574966967627";

        BigInteger fBig = new BigInteger(firstNumber);
        BigInteger sBig = new BigInteger(secondNumber);
        BigInteger answer = fBig.multiply(sBig);

        KaratsubaAlgorithm service = new KaratsubaAlgorithm();

        String result = service.multiply(firstNumber, secondNumber);
        System.out.println(result);


        Assertions.assertEquals(answer.toString(), result);
    }
}