package com.src.algorithm.datastructure.strings.prod;

/**
 * 环绕字符串中唯一子字符串
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/25
 */
public class UniqueSubstringInSurroundString {

    public int mySelf_HashUniqueSubstringInSurroundString(String needCheckCharacterString) {
        int[] numberOfLetters = new int[26];
        char[] needCheckCharacterArray = needCheckCharacterString.toCharArray();
        int count = 1;
        for (int needCheckCharacterArrayIndex = 0; needCheckCharacterArrayIndex < needCheckCharacterArray.length; needCheckCharacterArrayIndex++) {
            if (needCheckCharacterArrayIndex == 0) {
                count = 1;
                numberOfLetters[needCheckCharacterArray[needCheckCharacterArrayIndex] - 'a'] = 1;
            } else {
//      够不够一圈 够一圈就出现次数+1 不够一圈代表第一次出现
                int intervalRepetitions = needCheckCharacterArray[needCheckCharacterArrayIndex] - needCheckCharacterArray[needCheckCharacterArrayIndex - 1] - 1;
                if (intervalRepetitions % 26 == 0) {
                    count++;
                } else {
                    count = 1;
                }
//            和原本字母的出现次数相比较 谁大取谁
                numberOfLetters[needCheckCharacterArray[needCheckCharacterArrayIndex] - 'a'] = Math.max(numberOfLetters[needCheckCharacterArray[needCheckCharacterArrayIndex] - 'a'], count);

            }
        }
        int res = 0;
        for (int letterIndex = 0; letterIndex < 26; letterIndex++) {
            System.out.println(numberOfLetters[letterIndex]);
            res += numberOfLetters[letterIndex];
        }
        return res;

    }
}
