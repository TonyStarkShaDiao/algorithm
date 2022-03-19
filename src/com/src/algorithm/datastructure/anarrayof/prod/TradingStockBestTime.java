package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 交易股票最佳时机
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/25
 */
public class TradingStockBestTime {

    /**
     * 我自我动态规划交易股票最佳时机
     *
     * @param stockPriceArrayParam 股票价格数组参数
     * @return int
     */
    public int mySelf_DynamicProgrammingTradingStockBestTime(int[] stockPriceArrayParam) {
        int dayBeforeMinPrice = Integer.MAX_VALUE;
        int dayBeforeMaxEarnings = 0;
        for (int day = 0; day < stockPriceArrayParam.length; day++) {
            if (stockPriceArrayParam[day] < dayBeforeMinPrice) {
                dayBeforeMinPrice = stockPriceArrayParam[day];
            } else if (stockPriceArrayParam[day] - dayBeforeMinPrice > dayBeforeMaxEarnings) {
                dayBeforeMaxEarnings = stockPriceArrayParam[day] - dayBeforeMinPrice;
            }
        }
        return dayBeforeMaxEarnings;
    }
}
