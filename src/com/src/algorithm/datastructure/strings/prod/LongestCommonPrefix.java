package com.src.algorithm.datastructure.strings.prod;

/**
 * 最长公共前缀
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/17
 */
public class LongestCommonPrefix {

    public String columnLongestCommonPrefix(String[] characterStringArray) {
        if (characterStringArray == null || characterStringArray.length == 0) {
            return "";
        }
        int columnNumber = characterStringArray[0].length();
        int rowNumber = characterStringArray.length;
        for (int columNumberIndex = 0; columNumberIndex < columnNumber; columNumberIndex++) {
            char currentChar = characterStringArray[0].charAt(columNumberIndex);
            for (int rowNumberIndex = 1; rowNumberIndex < rowNumber; rowNumberIndex++) {
                if (characterStringArray[rowNumberIndex].length() == columNumberIndex || characterStringArray[rowNumberIndex].charAt(columNumberIndex) != currentChar) {
                    return characterStringArray[0].substring(0, columNumberIndex);
                }
            }
        }
        return characterStringArray[0];
    }

    public String rowLongestCommonPrefix(String[] characterStringArray) {
        if (characterStringArray == null || characterStringArray.length == 0) {
            return "";
        }
        String commonPrefix = characterStringArray[0];
        for (int rowNumberIndex = 1; rowNumberIndex < characterStringArray.length; rowNumberIndex++) {
            commonPrefix = this.stringCommonPrefix(commonPrefix, characterStringArray[rowNumberIndex]);
            if (commonPrefix.length() == 0) {
                break;
            }
        }
        return commonPrefix;
    }

    private String stringCommonPrefix(String commonPrefix, String stringToCompare) {
        int minArrayLength = Math.min(commonPrefix.length(), stringToCompare.length());
        int minArrayIndex = 0;
        while (minArrayLength < minArrayIndex && commonPrefix.charAt(minArrayIndex) == stringToCompare.charAt(minArrayIndex)) {
            minArrayIndex++;
        }
        return commonPrefix.substring(0, minArrayIndex);
    }
}
