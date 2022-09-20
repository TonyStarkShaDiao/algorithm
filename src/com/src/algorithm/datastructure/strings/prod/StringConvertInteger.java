package com.src.algorithm.datastructure.strings.prod;

/**
 * 字符串转换整数
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/14
 */
public class StringConvertInteger {

    public int mySelf_StringConvertInteger(String str) {
        if (str.equals("")) {
            return 0;
        }
        int strIndex = 0;
        boolean isItPositive = true;
        while (strIndex < str.length() && str.charAt(strIndex) == ' ') {
            strIndex++;
            if (strIndex == str.length()) {
                return 0;
            }
        }
        if (str.charAt(strIndex) == '+' || str.charAt(strIndex) == '-') {
            if (str.charAt(strIndex) == '+') {
                isItPositive = true;
                strIndex++;
            } else if (str.charAt(strIndex) == '-') {
                isItPositive = false;
                strIndex++;
            } else {
                return 0;
            }
        }
        int previousDigitValue = 0;
        while (strIndex < str.length() && str.charAt(strIndex) >= '0' && str.charAt(strIndex) <= '9') {

            int currentDigitValue = str.charAt(strIndex) - '0';
            if (isItPositive && (previousDigitValue > Integer.MAX_VALUE / 10 || previousDigitValue == Integer.MAX_VALUE / 10 && currentDigitValue > 7)) {
                return Integer.MAX_VALUE;
            }
            if (!isItPositive && (-previousDigitValue < Integer.MIN_VALUE / 10 || -previousDigitValue == Integer.MIN_VALUE / 10 && currentDigitValue > 8)) {
                return Integer.MIN_VALUE;
            }
            previousDigitValue *= 10;
            previousDigitValue = previousDigitValue + currentDigitValue;
            strIndex++;
        }
        return isItPositive ? previousDigitValue : -previousDigitValue;
    }
}
