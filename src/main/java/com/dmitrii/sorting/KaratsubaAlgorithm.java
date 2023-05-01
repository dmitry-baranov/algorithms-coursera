package com.dmitrii.sorting;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KaratsubaAlgorithm {

    public static void main(String[] args) {
        String firstNumber = "3141592653589793238462643383279502884197169399375105820974944592";
        String secondNumber = "2718281828459045235360287471352662497757247093699959574966967627";

        BigInteger first = new BigInteger(firstNumber);
        BigInteger second = new BigInteger(secondNumber);
        BigInteger answer = first.multiply(second);

        System.out.println("Right Answer: " + answer.toString());

        List<Short> firstArray = Arrays.stream(firstNumber.split("")).map(Short::parseShort).toList();
        List<Short> secondArray = Arrays.stream(secondNumber.split("")).map(Short::parseShort).toList();

        String result = multipleTwoDecimal(firstArray, secondArray);

        System.out.println(result);
    }

    private static String multipleTwoDecimal(List<Short> firstNumber, List<Short> secondNumber) {

        if ()

        for (int i = firstArray.size() - 1; i >= 0; i--) {
            for (int j = firstArray.size() - 1; j >= 0; j--) {

            }

        }

        System.out.println(firstArray);
        return "abc";
    }

    public static List<Short> mergeSort() {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        /*
        for (int i = 0; i < mid; i++) {
            leftArr[i] = array[i];
        }
         */
        System.arraycopy(array, 0, leftArr, 0, mid);

        /*
        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = array[i];
        }
         */
        System.arraycopy(array, mid, rightArr, 0, n - mid);
        mergeSort(leftArr, leftArr.length);
        mergeSort(rightArr, rightArr.length);

        merge(array, leftArr, rightArr, leftArr.length, rightArr.length);
    }
}
