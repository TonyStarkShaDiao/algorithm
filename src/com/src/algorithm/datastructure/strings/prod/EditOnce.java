package com.src.algorithm.datastructure.strings.prod;

/**
 * 编辑一次
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/13
 */
public class EditOnce {

    public boolean mySelf_isOneEditAway(String firstString, String secondString) {
        int firstLength = firstString.length();
        int secondLength = secondString.length();
        if (secondLength > firstLength) {
            return mySelf_isOneEditAway(secondString, firstString);
        }
        if (firstLength - secondLength > 1) {
            return false;
        }
        int firstStringIndex = 0;
        int secondStringIndex = 0;
        int operation = 0;
        while (firstStringIndex < firstLength && secondStringIndex < secondLength) {
            if (firstString.charAt(firstStringIndex) == secondString.charAt(secondStringIndex)) {
                firstStringIndex++;
                secondStringIndex++;
            } else {
                if (firstLength == secondLength) {
                    secondStringIndex++;
                }
                firstStringIndex++;
                operation++;
                if (operation > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
