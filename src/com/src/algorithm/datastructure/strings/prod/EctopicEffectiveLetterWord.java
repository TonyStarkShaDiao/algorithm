package com.src.algorithm.datastructure.strings.prod;

/**
 * 有效的字母异位词
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/10
 */
public class EctopicEffectiveLetterWord {

    /**
     * 我自己哈希数
     *
     * @param firstOneToCompareString 第一个比较字符串
     * @param secondToCompareString   第二个比较字符串
     * @return {@link Boolean}
     */
    public Boolean mySelf_HashCount(String firstOneToCompareString, String secondToCompareString) {
        if (firstOneToCompareString.length() != secondToCompareString.length()) {
            return false;
        }
        int[] countLetterNumberArray = new int[26];
        for (int characterIndex = 0; characterIndex < firstOneToCompareString.length(); characterIndex++) {
            countLetterNumberArray[firstOneToCompareString.charAt(characterIndex) - 'a']++;
        }
        for (int characterIndex = 0; characterIndex < secondToCompareString.length(); characterIndex++) {
            countLetterNumberArray[secondToCompareString.charAt(characterIndex) - 'a']--;
            if (countLetterNumberArray[secondToCompareString.charAt(characterIndex) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
