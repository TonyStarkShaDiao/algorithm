package com.src.algorithm.datastructure.mathematics.prod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin {

    Map<String, Boolean> map = new HashMap<>();

    public Boolean mySelf_toFlashBackCanIWin(int optionalMaximumNumber, int cumulativeTargetValueSum) {
        if ((optionalMaximumNumber + 1) * optionalMaximumNumber / 2 < cumulativeTargetValueSum) {
            return false;
        }
        char[] numberUsed = new char[optionalMaximumNumber + 1];
        Arrays.fill(numberUsed, '0');
        return toFlashBackCanIWin(optionalMaximumNumber, cumulativeTargetValueSum, numberUsed);
    }

    private boolean toFlashBackCanIWin(int optionalMaximumNumber, int cumulativeTargetValueSum, char[] numberUsed) {
        String key = new String(numberUsed);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = 1; i <= optionalMaximumNumber; i++) {
            if (numberUsed[i] == '1') {
                continue;
            }
            numberUsed[i] = '0';
            if (cumulativeTargetValueSum - i <= 0 || !toFlashBackCanIWin(optionalMaximumNumber, cumulativeTargetValueSum - i, numberUsed)) {
                map.put(key, true);
                numberUsed[i] = '0';
                return true;
            }
            numberUsed[i] = '0';
        }
        map.put(key, false);
        return false;
    }
}
