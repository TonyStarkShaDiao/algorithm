package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.FourNumberSum;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FourNumberSumTest {

    private FourNumberSum fourNumberSumUnderTest;
    private int[] needAnalysisArray;
    private int sumOfFourNumbers;
    List<List<Integer>> expectedResult;

    @BeforeEach
    void setUp() {
        needAnalysisArray = new int[]{1, 0, -1, 0, -2, 2};
        fourNumberSumUnderTest = new FourNumberSum();
        sumOfFourNumbers = 0;
        expectedResult = new ArrayList<>();
        expectedResult.add(new ArrayList<Integer>() {{
            add(-2);
            add(-1);
            add(1);
            add(2);
        }});
        expectedResult.add(new ArrayList<Integer>() {{
            add(-2);
            add(0);
            add(0);
            add(2);
        }});
        expectedResult.add(new ArrayList<Integer>() {{
            add(-1);
            add(0);
            add(0);
            add(1);
        }});


    }

    @Test
    void testMyself_FourNumberSum() {
        List<List<Integer>> result = fourNumberSumUnderTest.Myself_FourNumberSum(needAnalysisArray, sumOfFourNumbers);
        Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }
}
