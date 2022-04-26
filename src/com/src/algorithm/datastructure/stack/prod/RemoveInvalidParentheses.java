package com.src.algorithm.datastructure.stack.prod;

/**
 * 删除无效括号
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/26
 */
public class RemoveInvalidParentheses {

    public String mySelf_RemoveInvalidParentheses(String needCheckCharacterString) {

        int[] numberOfParentheses = new int[126];
        for (int i = 0; i < needCheckCharacterString.toCharArray().length; i++) {
            if (needCheckCharacterString.charAt(i) == '(') {
                numberOfParentheses[needCheckCharacterString.charAt(i)]++;
            } else if (needCheckCharacterString.charAt(i) == ')') {
                numberOfParentheses[needCheckCharacterString.charAt(i)]++;
            }
        }

        while (numberOfParentheses['('] != numberOfParentheses[')']) {
            if (numberOfParentheses['('] > numberOfParentheses[')']) {
                needCheckCharacterString = needCheckCharacterString.replaceFirst("\\(", "");
                numberOfParentheses['(']--;
            } else if (numberOfParentheses['('] < numberOfParentheses[')']) {
                needCheckCharacterString = needCheckCharacterString.replaceFirst("\\)", "");
                numberOfParentheses[')']--;
            }
        }
        return needCheckCharacterString;
    }

    public String mySelf_StringBuildRemoveInvalidParentheses(String needRemoveParenthesesCharacterString) {
        StringBuilder stringBuilder = new StringBuilder();
        int mismatchedParentheses = 0;
        int leftParenthesis = 0;
        for (int needCheckCharacterStringIndex = 0; needCheckCharacterStringIndex < needRemoveParenthesesCharacterString.length(); needCheckCharacterStringIndex++) {
            char currentCharacter = needRemoveParenthesesCharacterString.charAt(needCheckCharacterStringIndex);
            if (currentCharacter == '(') {
                mismatchedParentheses++;
                leftParenthesis++;
            } else if (currentCharacter == ')') {
                if (mismatchedParentheses == 0) {
                    continue;
                }
                mismatchedParentheses--;
            }
            stringBuilder.append(currentCharacter);
        }
        StringBuilder result = new StringBuilder();
        int extraLeftParenthesis = leftParenthesis - mismatchedParentheses;
        for (int i = 0; i < stringBuilder.length(); i++) {
            char currentCharacter = stringBuilder.charAt(i);
            if (currentCharacter == '(') {
                extraLeftParenthesis--;
                if (extraLeftParenthesis < 0) {
                    continue;
                }
            }
            result.append(currentCharacter);
        }
        return result.toString();
    }

    public String mySelf_SingleStringBuilderRemoveInvalidParentheses(String needRemoveParenthesesCharacterString) {
        StringBuilder removedStringResult = new StringBuilder();
        int numberOfLeftParentheses = 0;
        for (int i = 0; i < needRemoveParenthesesCharacterString.length(); i++) {
            char currentCharacter = needRemoveParenthesesCharacterString.charAt(i);
            if (currentCharacter == '(') {
                numberOfLeftParentheses++;
                removedStringResult.append(currentCharacter);
            } else if (currentCharacter == ')') {
                if (numberOfLeftParentheses > 0) {
                    numberOfLeftParentheses--;
                    removedStringResult.append(currentCharacter);
                }
            } else {
                removedStringResult.append(currentCharacter);
            }
        }

        for (int removedStringResultIndex = removedStringResult.length() - 1; removedStringResultIndex >= 0 && numberOfLeftParentheses > 0; removedStringResultIndex--) {
            char currentCharacter = removedStringResult.charAt(removedStringResultIndex);
            if (currentCharacter == '(') {
                removedStringResult.deleteCharAt(removedStringResultIndex);
                numberOfLeftParentheses--;
            }
        }
        return removedStringResult.toString();
    }
}
