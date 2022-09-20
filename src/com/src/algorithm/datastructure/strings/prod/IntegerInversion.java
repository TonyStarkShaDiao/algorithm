package com.src.algorithm.datastructure.strings.prod;

/**
 * 整数反转
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/14
 */
public class IntegerInversion {
    public int mySelf_IntegerInversion(int integerValue) {
        int PreviousDigitValue = 0;
        while (integerValue != 0) {
            if (PreviousDigitValue < Integer.MIN_VALUE / 10 || PreviousDigitValue == Integer.MIN_VALUE / 10) {
                return 0;
            }
            int CurrentDigitValue = integerValue % 10;
            integerValue /= 10;
            PreviousDigitValue = PreviousDigitValue * 10 + PreviousDigitValue * 10 + CurrentDigitValue;
        }
        return PreviousDigitValue;
    }
}
