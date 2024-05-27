package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.*;


/**
 * 重复DNA序列
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/19
 */
public class RepetitiveDNASequence {
    public List<String> mySelf_HashSlidingWindowRepetitiveDNASequence(String needAnalysisCharacterString) {
        StringBuilder characterWindowStringBuilder = new StringBuilder();
        List<String> subsequenceWindowCollect = new ArrayList<>();
        Map<String, Integer> substringCountCollect = new HashMap<>();
        for (int needAnalysisCharacterStringIndex = 0; needAnalysisCharacterStringIndex < needAnalysisCharacterString.length(); needAnalysisCharacterStringIndex++) {
            characterWindowStringBuilder.append(needAnalysisCharacterString.charAt(needAnalysisCharacterStringIndex));
            if (characterWindowStringBuilder.length() == 10) {
                String subsequenceStringKey = characterWindowStringBuilder.toString();
                Integer substringCountCount = substringCountCollect.getOrDefault(subsequenceStringKey, 0);
                if (substringCountCount == 1) {
                    subsequenceWindowCollect.add(subsequenceStringKey);
                }
                substringCountCollect.put(subsequenceStringKey, substringCountCount + 1);
                characterWindowStringBuilder.deleteCharAt(0);
            }
        }
        return subsequenceWindowCollect;
    }

    public List<String> myself_HashRepetitiveDNASequence(String needAnalysisCharacterString) {
        System.out.println(needAnalysisCharacterString);
        Set<String> substringCollect = new HashSet<>();
        Set<String> repeatingSubstringSet = new HashSet<>();
        for (int needAnalysisCharacterStringIndex = 0; needAnalysisCharacterStringIndex < getNeedAnalysisCharacterStringIndexLength(needAnalysisCharacterString); needAnalysisCharacterStringIndex++) {
            String repeatingSubstringKey = needAnalysisCharacterString.substring(needAnalysisCharacterStringIndex, needAnalysisCharacterStringIndex + 10);
            System.out.println(repeatingSubstringKey);
            if (!substringCollect.add(repeatingSubstringKey)) {
                repeatingSubstringSet.add(repeatingSubstringKey);
            }
        }
        return new ArrayList<>(repeatingSubstringSet);
    }

    /**
     * 获取需要分析字符串索引长度
     * -9是因为 最后十个以内的的字符是无法再向他之后再取十个的
     * 例如 ababaabccccc
     * -9=ababaabc 不需要往下遍历 因为后面的任何一个元素不可能再向他后面取十个组成一个袁术
     *
     * @param needAnalysisCharacterString 需要分析字符串吗
     * @return int
     */
    private int getNeedAnalysisCharacterStringIndexLength(String needAnalysisCharacterString) {
        return needAnalysisCharacterString.length() - 9;
    }
}
