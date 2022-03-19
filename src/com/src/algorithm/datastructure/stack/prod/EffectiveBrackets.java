package com.src.algorithm.datastructure.stack.prod;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效括号
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/21
 */
public class EffectiveBrackets {

//    public Boolean myself_StackEffectiveBrackets(String validationString) {
//        if (validationString.length() % 2 == 1) {
//            return false;
//        }
//        Map<Character, Character> matchingString = new HashMap<>();
//        matchingString.put(')', '(');
//        matchingString.put(']', '[');
//        matchingString.put('}', '{');
//        Deque<Character> characterStack = new LinkedList<>();
//        for (int validationStringIndex = 0; validationStringIndex < validationString.length(); validationStringIndex++) {
//            char validationCharacter = validationString.charAt(validationStringIndex);
//            if (matchingString.containsKey(validationCharacter)) {
//                if (characterStack.isEmpty()||!characterStack.peek() .equals(matchingString.get(validationCharacter)) ) {
//                    return false;
//                }
//                characterStack.pop();
//            }else {
//                characterStack.push(validationCharacter);
//            }
//        }
//        return characterStack.isEmpty();
//    }

//    public Boolean myself_StackEffectiveBrackets(String validationString) {
//        if (validationString.length() % 2 == 1) {
//            return false;
//        }
//        HashMap<Character, Character> matchingCharacterCollection = new HashMap<>();
//        matchingCharacterCollection.put(')', '(');
//        matchingCharacterCollection.put(']', '[');
//        matchingCharacterCollection.put('}', '{');
//        Deque<Character> characterStark = new LinkedList<>();
//        for (int validationStringIndex = 0; validationStringIndex < validationString.length(); validationStringIndex++) {
//            if (matchingCharacterCollection.containsKey(validationString.charAt(validationStringIndex))) {
//                if (characterStark.isEmpty() || !characterStark.peek().equals(matchingCharacterCollection.get(validationString.charAt(validationStringIndex)))) {
//                    return false;
//                }
//                characterStark.pop();
//            } else {
//                characterStark.push(validationString.charAt(validationStringIndex));
//            }
//        }
//        return characterStark.isEmpty();
//    }

//    public Boolean myself_recursiveEffectiveBrackets(String validationString) {
//        if (validationString.length() == 0) {
//            return true;
//        }
//        if (validationString.indexOf("()") == -1 && validationString.indexOf("{}") == -1 && validationString.indexOf("[]") == -1) {
//            return false;
//        }
//        //这里替换的时候要注意用返回的引用
//        validationString = validationString.replace("()", "");
//        validationString = validationString.replace("[]", "");
//        validationString = validationString.replace("{}", "");
//        return myself_recursiveEffectiveBrackets(validationString);
//    }

    public Boolean myself_recursiveEffectiveBrackets(String validationString) {
        if (0 == validationString.length()) {
            return false;
        }
        if (validationString.indexOf("()") == -1 && validationString.indexOf("{}") == -1 && validationString.indexOf("[]") == -1) {
            return false;
        }
        validationString = validationString.replace("()", "");
        validationString = validationString.replace("[]", "");
        validationString = validationString.replace("{}", "");
        return myself_recursiveEffectiveBrackets(validationString);
    }

    public Boolean myself_StackEffectiveBrackets(String validationString) {
        if (validationString.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> matchingCharacterCollection = new HashMap();
        matchingCharacterCollection.put('}', '{');
        matchingCharacterCollection.put(')', '(');
        matchingCharacterCollection.put(']', '[');
        Deque<Character> characterStack = new LinkedList<>();
        for (int validationStringIndex = 0; validationStringIndex < validationString.length(); validationStringIndex++) {
            if (matchingCharacterCollection.containsKey(validationString.charAt(validationStringIndex))) {
                if (characterStack.isEmpty() || !characterStack.peek().equals(matchingCharacterCollection.get(validationString.charAt(validationStringIndex)))) {
                    return false;
                }
                characterStack.pop();
            } else {
                characterStack.push(validationString.charAt(validationStringIndex));
            }
        }
        return characterStack.isEmpty();
    }
}
