package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.WritingRemoveDuplicates;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 编写删除重复元素算法题测试
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/10
 */
class WritingRemoveDuplicatesTest extends SimpleArgumentConverter {
    /**
     * 测试方法计数
     */
    int testMethodsCount = 0;

    @BeforeEach
    void setUp() {
        testMethodsCount++;
        System.out.println("开始测试");
    }

    @AfterEach
    void tearDown() {
    }

    @RepeatedTest(value = 3)
    @DisplayName("空测试¡")
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    void oneSelfWritingRemoveDuplicates() {
    }

    @CsvSource("'1,2,3,3,5,6,8,8'")
    @DisplayName("多参数测试")
    @ParameterizedTest
    void oneSelfWritingRemoveDuplicatesForManyParam(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] column3) {
        WritingRemoveDuplicates writingRemoveDuplicates = new WritingRemoveDuplicates();
        assertEquals(6, writingRemoveDuplicates.oneSelfWritingRemoveDuplicates(column3), "断言结果为");
    }

    @CsvSource("'1'")
    @DisplayName("单参数测试")
    @ParameterizedTest
    void oneSelfWritingRemoveDuplicatesForOneParam(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] column3) {
        WritingRemoveDuplicates writingRemoveDuplicates = new WritingRemoveDuplicates();
        assertEquals(1, writingRemoveDuplicates.oneSelfWritingRemoveDuplicates(column3), "断言结果为");
    }

    @CsvSource("''")
    @DisplayName("空数组测试")
    @ParameterizedTest
    void oneSelfWritingRemoveDuplicatesForEmptyParam(@ConvertWith(WritingRemoveDuplicatesTest.class) int[] column3) {
        WritingRemoveDuplicates writingRemoveDuplicates = new WritingRemoveDuplicates();
        assertEquals(1, writingRemoveDuplicates.oneSelfWritingRemoveDuplicates(column3), "断言结果为");
    }

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {

        if (source instanceof String) {
            if (StringUtils.isBlank((String) source)) {
                return new int[1];
            }

            String[] split = ((String) source).split(",");
            if (split.length==1){
                return Integer.parseInt(split[0]);
            }
            int[] paramArrays = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
            return paramArrays;
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }

    }
}