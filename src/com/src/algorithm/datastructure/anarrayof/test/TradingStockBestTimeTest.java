package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.TradingStockBestTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TradingStockBestTimeTest {
 private TradingStockBestTime tradingStockBestTime;
    @BeforeEach
    void setUp() {
        tradingStockBestTime =new TradingStockBestTime();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * 我自我动态规划交易股票最佳时机
     *
     * @param stockTradingArray 股票交易数组
     */
    @DisplayName("排序获取两个数组元素的交集(元素可重复)")
    @ParameterizedTest
    @CsvSource("7;1;5;3;6;4")
    void mySelf_DynamicProgrammingTradingStockBestTime(@ConvertWith(StringArrayConverterConfig.class)int [] stockTradingArray) {
        int maxEarnings = tradingStockBestTime.mySelf_DynamicProgrammingTradingStockBestTime(stockTradingArray);
        assertEquals(maxEarnings, 5, "期望的价格收益是5元");

    }

}