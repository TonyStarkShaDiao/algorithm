package com.src.algorithm.datastructure.strings.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效括号
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/17
 */
public class ValidParentheses {
    public List<String> Myself_toFlashBackValidParentheses(int bracketsLogarithm) {
        List<String> bracketCombinationCollect = new ArrayList<>();
        this.buildToFlashBackValidParentheses(bracketCombinationCollect, new StringBuilder(), 0, 0, bracketsLogarithm);
        return bracketCombinationCollect;
    }

    private void buildToFlashBackValidParentheses(List<String> bracketCombinationCollect, StringBuilder validParenthesesCharacterString, int leftBracketCount, int rightBracketCount, int maxBracketCount) {
        if (validParenthesesCharacterString.length() == maxBracketCount * 2) {
            bracketCombinationCollect.add(validParenthesesCharacterString.toString());
            return;
        }
        if (leftBracketCount < maxBracketCount) {
            validParenthesesCharacterString.append("(");
            this.buildToFlashBackValidParentheses(bracketCombinationCollect, validParenthesesCharacterString, leftBracketCount + 1, rightBracketCount, maxBracketCount);
            validParenthesesCharacterString.deleteCharAt(validParenthesesCharacterString.length() - 1);
        }
        if (rightBracketCount < leftBracketCount) {
            validParenthesesCharacterString.append(")");
            this.buildToFlashBackValidParentheses(bracketCombinationCollect, validParenthesesCharacterString, leftBracketCount, rightBracketCount + 1, maxBracketCount);
            validParenthesesCharacterString.deleteCharAt(validParenthesesCharacterString.length() - 1);
        }
    }

    private void addDataToFlashBackValidParentheses(List<String> bracketCombinationCollect, StringBuilder validParenthesesCharacterString, int leftBracketCount, int rightBracketCount, int maxBracketCount) {
        if (leftBracketCount > maxBracketCount || rightBracketCount > leftBracketCount) {
            return;
        }
        if (validParenthesesCharacterString.length() == maxBracketCount * 2) {
            bracketCombinationCollect.add(validParenthesesCharacterString.toString());
            return;
        }
        validParenthesesCharacterString.append("(");
        this.addDataToFlashBackValidParentheses(bracketCombinationCollect, validParenthesesCharacterString, leftBracketCount + 1, rightBracketCount, maxBracketCount);
        validParenthesesCharacterString.deleteCharAt(validParenthesesCharacterString.length() - 1);
        validParenthesesCharacterString.append(")");
        this.addDataToFlashBackValidParentheses(bracketCombinationCollect, validParenthesesCharacterString, leftBracketCount, rightBracketCount + 1, maxBracketCount);
        validParenthesesCharacterString.deleteCharAt(validParenthesesCharacterString.length() - 1);
    }
}
