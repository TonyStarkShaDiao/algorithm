package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 两个字符串添加
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/17
 */
public class TwoStringsAdd {
    //    字符串相加
    public String mySelf_TwoStringAdd(String firstOneString, String secondOneString) {
        int fistOneStringIndex = firstOneString.length() - 1;
        int secondOneStringIndex = secondOneString.length() - 1;
        StringBuilder stringAddResult = new StringBuilder();
        int digitsCarry = 0;
        while (fistOneStringIndex >= 0 || secondOneStringIndex >= 0) {
            int currentFirstOneStringDigitsElement = firstOneString.charAt(fistOneStringIndex) - '0';
            int currentSecondOneStringDigitsElement = secondOneString.charAt(secondOneStringIndex) - '0';
            int currentDigitsSum = currentFirstOneStringDigitsElement + currentSecondOneStringDigitsElement + digitsCarry;
            stringAddResult.append(currentDigitsSum % 10);
            digitsCarry = currentDigitsSum / 10;
            fistOneStringIndex--;
            secondOneStringIndex--;
        }
        if (digitsCarry != 0) {
            stringAddResult.append(digitsCarry);
        }
        return stringAddResult.reverse().toString();
    }
}
