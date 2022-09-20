package com.src.algorithm.datastructure.strings.prod;

import java.util.HashMap;
import java.util.Map;

/**
 * 古罗马数字转换为整数
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/17
 */
public class RomanNumeralToInteger {

    public int mySelf_RomanNumeralToInteger(String romanNumerals) {
        int result = 0;
        for (int i = 1; i < romanNumerals.length(); i++) {
            if (getValue(romanNumerals.charAt(i)) < getValue(romanNumerals.charAt(i - 1))) {
                result -= getValue(romanNumerals.charAt(i));
            } else {
                result += getValue(romanNumerals.charAt(i));
            }
        }
        return result;

    }

    private int getValue(char romanCharacters) {
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        return symbolValues.get(romanCharacters);
    }
}
