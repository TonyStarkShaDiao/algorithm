package com.src.algorithm.datastructure.strings.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码字母组合
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/17
 */
public class LetterCombinationOfTelephoneNumber {

    public List<String> mySelf_toFlashBackLetterCombinationOfTelephoneNumber(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        this.toFlashBackLetterCombinationOfTelephoneNumber(digits, result, 0, new StringBuilder());
        return result;
    }

    private void toFlashBackLetterCombinationOfTelephoneNumber(String digits, List<String> result, int Index, StringBuilder currentCharacterString) {
        if (Index == digits.length()) {
            result.add(currentCharacterString.toString());
        }
        String currentNumberCharacterString = this.getCharacter(digits.charAt(Index));
        for (int i = 0; i < currentNumberCharacterString.length(); i++) {
            currentCharacterString.append(currentNumberCharacterString.charAt(i));
            this.toFlashBackLetterCombinationOfTelephoneNumber(digits, result, Index + 1, currentCharacterString);
            currentCharacterString.deleteCharAt(currentCharacterString.length() - 1);
        }
    }

    private String getCharacter(char c) {
        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}
