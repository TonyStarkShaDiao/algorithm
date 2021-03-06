package com.src.algorithm.datastructure.stack.test;

import com.src.algorithm.datastructure.stack.prod.EffectiveBrackets;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class EffectiveBracketsTest {
    EffectiveBrackets effectiveBrackets;

    @BeforeEach
    void setUp() {
        effectiveBrackets = new EffectiveBrackets();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @ValueSource(strings = {"()","" ,"({})","{([])}"})
    @DisplayName("判断有效括号的正确性")
    void myself_StackEffectiveBracketsSuccessTest(String validationOfString) {
        Boolean validationResult = effectiveBrackets.myself_StackEffectiveBrackets(validationOfString);
        Assertions.assertTrue(validationResult,"匹配失败");
    }
    @ParameterizedTest
    @ValueSource(strings = {"((","){"})
    @DisplayName("判断有效括号的正确性")
    void myself_StackEffectiveBracketsFailTest(String validationOfString) {
        Boolean validationResult = effectiveBrackets.myself_StackEffectiveBrackets(validationOfString);
        Assertions.assertFalse(validationResult,"匹配失败");
    }

    @ParameterizedTest
    @ValueSource(strings = {"()","" ,"({})","{([])}"})
    @DisplayName("判断有效括号的正确性")
    void myself_recursiveEffectiveBrackets(String validationOfString) {
        effectiveBrackets.myself_recursiveEffectiveBrackets(validationOfString);
    }
}