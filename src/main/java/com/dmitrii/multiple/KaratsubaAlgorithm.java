package com.dmitrii.multiple;

import java.util.Stack;

public class KaratsubaAlgorithm {

    public String multiply(String firstNumber, String secondNumber) {
        int maxLength = Math.max(firstNumber.length(), secondNumber.length());
        maxLength = maxLength % 2 == 0 ? maxLength : maxLength + 1;
        String firstFilled = firstNumber;
        String secondFilled = secondNumber;
        if (firstNumber.length() < maxLength) {
            firstFilled = addZeroesToStrat(firstNumber, maxLength - firstNumber.length());
        }
        if (secondNumber.length() < maxLength) {
            secondFilled = addZeroesToStrat(secondNumber, maxLength - secondNumber.length());
        }
        return multiplyNumbers(firstFilled, secondFilled);
    }

    public String multiplyNumbers(String firstNumber, String secondNumber) {
        if (firstNumber.length() < 2 && secondNumber.length() < 2) {
            return String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
        }
        int n = Math.max(firstNumber.length(), secondNumber.length());
        n = n % 2 == 1 ? n + 1 : n;
        int midlIndexFirst = n / 2 >= firstNumber.length() ? 0 : n / 2;
        int midlIndexSecond = n / 2 >= secondNumber.length() ? 0 : n / 2;
        String a = firstNumber.substring(0, midlIndexFirst);
        String b = firstNumber.substring(midlIndexFirst);
        String c = secondNumber.substring(0, midlIndexSecond);
        String d = secondNumber.substring(midlIndexSecond);

        String ac10n = multipleByPowerOfTen(multiplyNumbers(a, c), n);
        String adbc10n2 = multipleByPowerOfTen(sumTwoNumbers(multiplyNumbers(a, d), multiplyNumbers(b, c)), n / 2);
        String bd = String.valueOf(multiplyNumbers(b, d));

        return sumTwoNumbers(sumTwoNumbers(ac10n, adbc10n2), bd);
    }

    private String addZeroesToStrat(String number, int count) {
        StringBuilder addition = new StringBuilder();
        for (int i = 0; i < count; i++) {
            addition.append("0");
        }
        return addition + number;
    }

    private String sumTwoNumbers(String firstNumber, String secondNumber) {
        Stack<Integer> f = putToStack(firstNumber);
        Stack<Integer> s = putToStack(secondNumber);
        int temp = 0;
        StringBuilder result = new StringBuilder();
        while (!f.empty() || !s.empty()) {
            int e1 = f.empty() ? 0 : f.pop();
            int e2 = s.empty() ? 0 : s.pop();
            int sum = e1 + e2 + temp;
            result.append(sum % 10);
            temp = sum / 10;
        }
        if (temp != 0) {
            result.append(temp);
        }
        result.reverse();
        return result.toString();
    }

    private Stack<Integer> putToStack(String string) {
        int i = 0;
        Stack<Integer> result = new Stack<>();
        while (i < string.length()) {
            result.push(Integer.parseInt(String.valueOf(string.charAt(i))));
            i++;
        }
        return result;
    }

    private String multipleByPowerOfTen(String number, int count) {
        StringBuilder addition = new StringBuilder();
        for (int i = 0; i < count; i++) {
            addition.append("0");
        }
        return number + addition;
    }
}
