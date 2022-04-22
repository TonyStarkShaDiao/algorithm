package com.src.algorithm.datastructure.anarrayof.prod;

import java.time.chrono.IsoEra;
import java.util.ArrayList;
import java.util.List;

/**
 * 异位词分组
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/18
 */
public class EctopicWordGrouping {

    public List<List<String>> mySelf_compareCharactersEctopicWordGrouping(String[] ectopicWordsArray) {
        List<List<String>> ectopicWordGroupingCollect = new ArrayList<>();
        for (String ectopicWords : ectopicWordsArray) {
            Boolean isNewEctopicWordGroup = true;
            for (int i = 0; i < ectopicWordGroupingCollect.size(); i++) {
                if (isEctopicWords(ectopicWords, ectopicWordGroupingCollect.get(i).get(0))) {
                    ectopicWordGroupingCollect.get(i).add(ectopicWords);
                    isNewEctopicWordGroup = false;
                    break;
                }
            }
            if (isNewEctopicWordGroup) {
                List<String> newEctopicWordGroup = new ArrayList<>();
                newEctopicWordGroup.add(ectopicWords);
                ectopicWordGroupingCollect.add(newEctopicWordGroup);
            }
        }
        return ectopicWordGroupingCollect;
    }

    private Boolean isEctopicWords(String firstWord, String secondWord) {
        if (firstWord.length() != secondWord.length()) {
            return false;
        }
        int[] characterArray = new int[26];
        for (int i = 0; i < firstWord.length(); i++) {
            characterArray[firstWord.charAt(i) - 'a']++;
            characterArray[secondWord.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (characterArray[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
