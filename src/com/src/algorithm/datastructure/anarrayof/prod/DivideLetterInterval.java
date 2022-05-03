package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/18
 */
public class DivideLetterInterval {
    public List<Integer> mySelf_DivideLetterInterval(String needAnalyticIntervalCharacterString) {
        List<Integer> eachCharacterStringSectionLengthCollect = new ArrayList<>();
        int[] characterLastIndexArray = new int[26];
        for (int characterLastIndexArrayIndex = 0; characterLastIndexArrayIndex < needAnalyticIntervalCharacterString.length(); ++characterLastIndexArrayIndex) {
            characterLastIndexArray[needAnalyticIntervalCharacterString.charAt(characterLastIndexArrayIndex) - 'a'] = characterLastIndexArrayIndex;
        }
        int currentStartPointIndex = 0;
        int currentEndPointIndex = 0;
        for (int i = 0; i < needAnalyticIntervalCharacterString.length(); ++i) {
            currentEndPointIndex = Math.max(currentEndPointIndex, characterLastIndexArray[needAnalyticIntervalCharacterString.charAt(i) - 'a']);
            if (currentEndPointIndex == i) {
                eachCharacterStringSectionLengthCollect.add(currentEndPointIndex - currentStartPointIndex + 1);
                currentStartPointIndex = currentEndPointIndex + 1;
            }
        }
        return eachCharacterStringSectionLengthCollect;
    }

    public List<Integer> mySelf_secondDivideLetterInterval(String needAnalyticIntervalCharacterString) {
        int[] characterLastIndexArray = new int[26];
        for (int currentCharacterIndex = 0; currentCharacterIndex < needAnalyticIntervalCharacterString.length(); currentCharacterIndex++) {
            characterLastIndexArray[needAnalyticIntervalCharacterString.charAt(currentCharacterIndex) - 'a'] = currentCharacterIndex;
        }
        int currentStartPointIndex = 0;
        int currentEndPointIndex = 0;
        List<Integer> eachCharacterStringSectionLengthCollect = new ArrayList<>();
        for (int currentCharacterIndex = 0; currentCharacterIndex < needAnalyticIntervalCharacterString.length(); currentCharacterIndex++) {
            currentEndPointIndex = Math.max(currentEndPointIndex, characterLastIndexArray[needAnalyticIntervalCharacterString.charAt(currentCharacterIndex) - 'a']);
            if (currentEndPointIndex == currentCharacterIndex) {
                eachCharacterStringSectionLengthCollect.add(currentEndPointIndex - currentStartPointIndex + 1);
                currentStartPointIndex = currentEndPointIndex + 1;
            }
        }
        return eachCharacterStringSectionLengthCollect;
    }
}
