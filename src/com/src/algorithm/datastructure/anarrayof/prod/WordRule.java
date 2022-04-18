package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词规则
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/17
 */
public class WordRule {
    /**
     * §
     * 我自我单词和规律是否匹配
     *
     * @param word    单词
     * @param pattern 图案
     * @return {@code Boolean}
     */
    public Boolean mySelf_wordsAndRulesWhetherMatching(String word, String pattern) {
        String[] singleFieldArray = word.split(" ");
        if (singleFieldArray.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> ruleMappingContainer = new HashMap<>();
        for (Integer currentSingleFieldIndex = 0; currentSingleFieldIndex < singleFieldArray.length; currentSingleFieldIndex++) {
            if (ruleMappingContainer.put(singleFieldArray[currentSingleFieldIndex], currentSingleFieldIndex) != ruleMappingContainer.put(pattern.charAt(currentSingleFieldIndex), currentSingleFieldIndex)) {
                return false;
            }
        }
        return true;
    }
}
