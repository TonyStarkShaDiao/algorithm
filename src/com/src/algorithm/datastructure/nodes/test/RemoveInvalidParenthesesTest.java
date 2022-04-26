package com.src.algorithm.datastructure.nodes.test;

import com.src.algorithm.datastructure.stack.prod.RemoveInvalidParentheses;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.*;

//
class RemoveInvalidParenthesesTest {

    private RemoveInvalidParentheses removeInvalidParentheses;
    private String needRemoveParenthesesCharacterString;
    private String reverseBracketNeedRemoveParenthesesCharacterString;
    private String reverseBracketExpectValue;
    private String expectValue;

    @BeforeEach
    void setUp() {
        removeInvalidParentheses = new RemoveInvalidParentheses();
        needRemoveParenthesesCharacterString = "a((bc)";
        reverseBracketNeedRemoveParenthesesCharacterString = "))((";
        expectValue = "a(bc)";
        reverseBracketExpectValue = "";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mySelf_RemoveInvalidParentheses() {
        removeInvalidParentheses.mySelf_RemoveInvalidParentheses(needRemoveParenthesesCharacterString);
    }

    @DisplayName("forwardBracket")
    @Test
    void mySelf_StringBuildRemoveInvalidParentheses() {
        String needCheckCharacterStringResult = removeInvalidParentheses.mySelf_StringBuildRemoveInvalidParentheses(needRemoveParenthesesCharacterString);
        Assertions.assertEquals(expectValue, needCheckCharacterStringResult);

    }


    @DisplayName("reverseBracket")
    @Test
    void mySelf_ReverseBracketStringBuildRemoveInvalidParentheses() {
        String needCheckCharacterStringResult = removeInvalidParentheses.mySelf_StringBuildRemoveInvalidParentheses(reverseBracketNeedRemoveParenthesesCharacterString);
        Assertions.assertEquals(reverseBracketExpectValue, needCheckCharacterStringResult);
    }

    @Test
    void mySelf_SingleStringBuilderRemoveInvalidParentheses() {
        String needCheckCharacterStringResult = removeInvalidParentheses.mySelf_SingleStringBuilderRemoveInvalidParentheses(needRemoveParenthesesCharacterString);
        Assertions.assertEquals(expectValue, needCheckCharacterStringResult);
    }


    @Test
    void mySelf_ReverseBracketSingleStringBuilderRemoveInvalidParentheses() {
        String needCheckCharacterStringResult = removeInvalidParentheses.mySelf_SingleStringBuilderRemoveInvalidParentheses(reverseBracketNeedRemoveParenthesesCharacterString);
        Assertions.assertEquals(reverseBracketExpectValue, needCheckCharacterStringResult);
    }

    @Test
    void mySelf_ErrorCaseSingleStringBuilderRemoveInvalidParentheses() {
        reverseBracketNeedRemoveParenthesesCharacterString = "())()(((";
        String needCheckCharacterStringResult = removeInvalidParentheses.mySelf_SingleStringBuilderRemoveInvalidParentheses(reverseBracketNeedRemoveParenthesesCharacterString);
        Assertions.assertEquals(reverseBracketExpectValue, needCheckCharacterStringResult);
    }
}