package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 最长回文子串
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/21
 */
public class LongestPalindromicSubstring {

    public String mySelf_centralDiffusionLongestPalindromicSubstring(String needAnalysisCharacterString) {
        int palindromeSubstringMaxlength = 0;
        int palindromeSubstringStartIndex = 0;
        for (int needAnalysisCharacterStringIndex = 0; needAnalysisCharacterStringIndex < needAnalysisCharacterString.length(); needAnalysisCharacterStringIndex++) {
            //为什么同一个中心要计算两种情况,因为回文可能是奇数也可能是偶数
            int oddNumberLengthOfPalindromeSubstring = getLengthOfPalindromeSubstring(needAnalysisCharacterString, needAnalysisCharacterStringIndex, needAnalysisCharacterStringIndex);
            int evenNumbersLengthOfPalindromeSubstring = getLengthOfPalindromeSubstring(needAnalysisCharacterString, needAnalysisCharacterStringIndex, needAnalysisCharacterStringIndex + 1);
            int currentPalindromeSubstringMaxlength = Math.max(oddNumberLengthOfPalindromeSubstring, evenNumbersLengthOfPalindromeSubstring);
            if (currentPalindromeSubstringMaxlength > palindromeSubstringMaxlength) {
                palindromeSubstringMaxlength = currentPalindromeSubstringMaxlength;
                //中心点-回文子串长度/2=起始位置 下标needAnalysisCharacterStringIndex从0开始所以结果要+1
                palindromeSubstringStartIndex = needAnalysisCharacterStringIndex - getLengthOfPalindromeSubstring(currentPalindromeSubstringMaxlength);
            }
        }
        return needAnalysisCharacterString.substring(palindromeSubstringStartIndex, palindromeSubstringStartIndex + palindromeSubstringMaxlength);
    }

    public String mySelf_SecondCentralDiffusionLongestPalindromicSubstring(String needAnalysisCharacterString) {
        int maximumPalindromeLength = 0;
        int initialPositionOfPalindromeSubstring = 0;
        for (int needAnalysisCharacterStringIndex = 0; needAnalysisCharacterStringIndex < needAnalysisCharacterString.length(); needAnalysisCharacterStringIndex++) {
            int oddLength = getsLengthOfPalindromeSubstring(needAnalysisCharacterString, needAnalysisCharacterStringIndex, needAnalysisCharacterStringIndex);
            int evenLength = getsLengthOfPalindromeSubstring(needAnalysisCharacterString, needAnalysisCharacterStringIndex, needAnalysisCharacterStringIndex + 1);
            int currentPalindromeLength = Math.max(oddLength, evenLength);
            if (currentPalindromeLength > maximumPalindromeLength) {
                maximumPalindromeLength = currentPalindromeLength;
                initialPositionOfPalindromeSubstring = needAnalysisCharacterStringIndex - (currentPalindromeLength - 1) / 2;
            }
        }
        return needAnalysisCharacterString.substring(initialPositionOfPalindromeSubstring, initialPositionOfPalindromeSubstring + maximumPalindromeLength);
    }

    private int getsLengthOfPalindromeSubstring(String needAnalysisCharacterString, int needAnalysisCharacterStringLeftBoundaryIndex, int needAnalysisCharacterStringRightBoundaryIndex) {
        while (needAnalysisCharacterStringLeftBoundaryIndex >= 0 && needAnalysisCharacterStringRightBoundaryIndex < needAnalysisCharacterString.length()
                && needAnalysisCharacterString.charAt(needAnalysisCharacterStringLeftBoundaryIndex) == needAnalysisCharacterString.charAt(needAnalysisCharacterStringRightBoundaryIndex)) {
            needAnalysisCharacterStringLeftBoundaryIndex--;
            needAnalysisCharacterStringRightBoundaryIndex++;
        }

        return needAnalysisCharacterStringRightBoundaryIndex - needAnalysisCharacterStringLeftBoundaryIndex - 1;
    }

    /**
     * 获取回文子串长度 由于是从两边同时扩散的
     * 所以起始位置就编程 当前中心点/2 为什么需要+1 是因为不确定是奇数还是偶数
     *
     * @param currentPalindromeSubstringMaxlength 当前回文子串maxlength
     * @return int
     */
    private int getLengthOfPalindromeSubstring(int currentPalindromeSubstringMaxlength) {
        return (currentPalindromeSubstringMaxlength - 1) / 2;
    }

    int getLengthOfPalindromeSubstring(String needAnalysisCharacterString, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < needAnalysisCharacterString.length() && needAnalysisCharacterString.charAt(leftIndex) == needAnalysisCharacterString.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return rightIndex - leftIndex - 1;
    }
}
