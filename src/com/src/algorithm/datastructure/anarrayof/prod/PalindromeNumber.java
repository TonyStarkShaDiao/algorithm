package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 回文数
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/22
 */

public class PalindromeNumber {

    public boolean mySelf_tailInsertionPalindromeNumber(int checkNumber) {
        if (checkNumber < 0) {
            return false;
        }
        int reverseNumber = 0;
        int currentNumber = checkNumber;
        while (currentNumber != 0) {
            reverseNumber = reverseNumber * 10 + currentNumber % 10;
            currentNumber = currentNumber / 10;
        }
        return reverseNumber == checkNumber;
    }
}
