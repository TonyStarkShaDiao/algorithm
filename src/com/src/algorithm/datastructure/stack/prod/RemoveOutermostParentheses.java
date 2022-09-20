package com.src.algorithm.datastructure.stack.prod;

/**
 * 删除最外面括号
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/28
 */
public class RemoveOutermostParentheses {
    public String MySelf_CountRemoveOutermostParentheses(String toBeResolvedString) {
        int count = 0;
        StringBuilder deletedString = new StringBuilder();
        for (int toBeResolvedStringIndex = 0; toBeResolvedStringIndex < toBeResolvedString.length(); toBeResolvedStringIndex++) {
            char currentCharacter = toBeResolvedString.charAt(toBeResolvedStringIndex);
            if (currentCharacter == ')') {
                count--;
            }
            if (count > 0) {
                deletedString.append(currentCharacter);
            }
            if (currentCharacter == '(') {
                count++;
            }
        }
        return deletedString.toString();
    }
}
