package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 最长回文子串
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/17
 */
public class LongestPalindromicSubstringLength {

    /**
     * 我自己的最长回文子串
     *
     * @param needFindCharacterString 需要查找的字符串
     * @return int
     */
    public int myself_LongestPalindromicSubstring(String needFindCharacterString) {
        int[] collectingLettersOccurrences = new int[52];
        for (char c : needFindCharacterString.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                collectingLettersOccurrences[c - 'a']++;
            } else {
                collectingLettersOccurrences[c - 'A' + 26]++;
            }

        }
        int characterCount = 0;
        Boolean isThereAnOddNumber = false;
        for (int collectingLettersOccurrence : collectingLettersOccurrences) {
            if (isItEvenNumber(collectingLettersOccurrence)) {
                characterCount += collectingLettersOccurrence;
            } else {
                characterCount += collectingLettersOccurrence - 1;
                isThereAnOddNumber = true;
            }
        }
        return isThereAnOddNumber ? characterCount + 1 : characterCount;
    }

    /**
     * 是偶数吗
     *
     * @param collectingLettersOccurrence 收集信件
     * @return boolean
     */
    private boolean isItEvenNumber(int collectingLettersOccurrence) {
        return collectingLettersOccurrence % 2 == 0;
    }
}
