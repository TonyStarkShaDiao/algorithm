package com.src.algorithm.datastructure.strings.prod;

/**
 * 赎金信
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/02/07
 */
public class RansomLetter {
    /**
     * 我自己字符数
     *
     * @param needJudgeString 需要判断字符串
     * @param toCompareString 比较字符串
     * @return {@link Boolean}
     */
    public  Boolean mySelf_CharterCountStatistical(String needJudgeString,String toCompareString){
        int[] charterCountStatisticalArray  =new int[128];
        for (int i = 0; i < needJudgeString.length(); i++) {
            charterCountStatisticalArray[needJudgeString.charAt(i)]++;
        }
        for (int i = 0; i < toCompareString.length(); i++) {
            charterCountStatisticalArray[toCompareString.charAt(i)]--;
        }
        for (int i = 0; i < charterCountStatisticalArray.length; i++) {
            if (charterCountStatisticalArray[i]>0){
                return true;
            }
        }
        return true;
    }
}


