package com.src.algorithm.datastructure.strings.prod;

/**
 * 验证外星人词典
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/17
 */
public class VerifyAlienDictionary {

    public boolean mySelf_doublePointVerifyAlienDictionary(String[] words, String Alphabet) {
        int[] alphabetArray = new int[Alphabet.length()];
        for (int i = 0; i < Alphabet.length(); i++) {
            alphabetArray[Alphabet.charAt(i) - 'a'] = i;
        }
        cycleStartingPoint:
        for (int i = 0; i < words.length - 1; i++) {
            String firstLetter = words[i];
            String secondLetter = words[i + 1];
            int minLength = Math.min(firstLetter.length(), secondLetter.length());
            for (int shorterStringArrayIndex = 0; shorterStringArrayIndex < minLength; shorterStringArrayIndex++) {
                if (firstLetter.charAt(shorterStringArrayIndex) != secondLetter.charAt(shorterStringArrayIndex)) {
                    if (alphabetArray[firstLetter.charAt(shorterStringArrayIndex) - 'a'] > alphabetArray[secondLetter.charAt(shorterStringArrayIndex) - 'a']) {
                        return false;
                    } else {
                        continue cycleStartingPoint;
                    }
                }
            }
            if (firstLetter.length() > secondLetter.length()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            index[order.charAt(i) - 'a'] = i;
        }

        search:
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']) {
                        return false;
                    } else {
                        System.out.println();
                        continue search;
                    }
                }
            }
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }
}
