package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.OnlyOnceNumber;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OnlyOnceNumberTest {

    OnlyOnceNumber onlyOnceNumber;
    private int expectedDontRepeatNumberResult;

    @BeforeEach
    void setUp() {
        onlyOnceNumber =new OnlyOnceNumber();
        expectedDontRepeatNumberResult= 4;
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @DisplayName("hashMap正确性验证测试")
    @CsvSource("'4,1,2,1,2'")
    void mySelf_HashFindOnlyOnceNumberInArray(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray ) {
        int dontRepeatNumbersResult = onlyOnceNumber.mySelf_HashFindOnlyOnceNumberInArray(specifiedFindArray);
        Assertions.assertEquals(expectedDontRepeatNumberResult, dontRepeatNumbersResult);
    }

    @ParameterizedTest
    @DisplayName("异或正确性验证测试")
    @CsvSource("'4,1,2,1,2'")
    void mySelf_ExclusiveOrFindOnlyOnceNumberInArray(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] specifiedFindArray) {
        int dontRepeatNumbersResult = onlyOnceNumber.mySelf_HashFindOnlyOnceNumberInArray(specifiedFindArray);
        Assertions.assertEquals(expectedDontRepeatNumberResult, dontRepeatNumbersResult);
    }
}