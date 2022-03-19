package com.src.algorithm.datastructure.strings.prod;


import java.util.HashMap;
import java.util.Map;

/**
 * 无重复第一个字符字符串
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/26
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WithoutRepetitionFirstCharInString {

    /**
     * 我自己哈希
     *
     * @param NeedToFindStringParam 需要找到字符串参数
     * @return int
     */
    public int mySelf_Hash(String NeedToFindStringParam) {
        HashMap<Character, Integer> characterCount = new HashMap<>(NeedToFindStringParam.length());
        for (int charIndex = 0; charIndex < NeedToFindStringParam.length(); charIndex++) {
            char characterElement = NeedToFindStringParam.charAt(charIndex);
            characterCount.put(characterElement, characterCount.getOrDefault(characterElement, 0) + 1);
        }
        for (int charIndex = 0; charIndex < NeedToFindStringParam.length(); charIndex++) {
            if (characterCount.get(NeedToFindStringParam.charAt(charIndex)) == 1) {
                return charIndex;
            }
        }
        return -1;
    }

    /**
     * 我自我改进哈希
     *
     * @param NeedToFindStringParam 需要找到字符串参数
     * @return int
     */
    public int mySelf_ImprovedHash(String NeedToFindStringParam) {
        Map<Character, Integer> characterCount = new HashMap<>(NeedToFindStringParam.length());
        for (int characterIndex = 0; characterIndex < NeedToFindStringParam.length(); characterIndex++) {
            if (characterCount.containsKey(NeedToFindStringParam.charAt(characterIndex))) {
                characterCount.put(NeedToFindStringParam.charAt(characterIndex), -1);
            } else {
                characterCount.put(NeedToFindStringParam.charAt(characterIndex), characterIndex);
            }
        }
        int lastOneIndex = NeedToFindStringParam.length();
        for (Map.Entry<Character, Integer> characterIntegerEntry : characterCount.entrySet()) {
            int characterIndex = characterIntegerEntry.getValue();
            if (characterIndex != -1 && characterIndex < lastOneIndex) {
                lastOneIndex = characterIndex;
            }
        }
        return lastOneIndex == NeedToFindStringParam.length() ? -1 : lastOneIndex;
    }

    /**
     * 我自己的二元组
     *
     * @param NeedToFindStringParam 需要找到字符串参数
     *                              二元组算法的精髓就在于可以将一维数组的下标设置原原字符串中字符的ASCII码 而值就是出现的次数，由于数组的插入顺序是有序的 只要找到第一个不重复的就是
     *                              所需要的答案
     * @return int
     */
    public int mySelf_TwoTuples(String NeedToFindStringParam) {
        char[] charArray = NeedToFindStringParam.toCharArray();
        char[] twoTuples = new char[128];
        for (int characterIndex = 0; characterIndex < charArray.length; characterIndex++) {
            twoTuples[charArray[characterIndex]]++;
        }
        for (int twoTuplesIndex = 0; twoTuplesIndex < twoTuples.length; twoTuplesIndex++) {
            if (twoTuples[charArray[twoTuplesIndex]] == 1) {
                return twoTuplesIndex;
            }
        }
        return -1;
    }

    /**
     * 我自己的二元组
     *
     * @param NeedToFindStringParam 需要找到字符串参数
     *                              二元组算法的精髓就在于可以将一维数组的下标设置原原字符串中字符的ASCII码 而值就是出现的次数，由于数组的插入顺序是有序的 只要找到第一个不重复的就是
     *                              所需要的答案
     * @return int
     */
    public int mySelf_ImprovedCharacterIndex(String NeedToFindStringParam) {
        int minIndex = Integer.MAX_VALUE;
        for (char character = 'a'; character <= 'z'; character++) {
            int characterIndex = NeedToFindStringParam.indexOf(character);
            if (characterIndex != -1 && characterIndex == NeedToFindStringParam.lastIndexOf(character) && minIndex > characterIndex) {
                minIndex = characterIndex;
            }
        }
        return NeedToFindStringParam.length() > minIndex ? minIndex : -1;
    }
}
