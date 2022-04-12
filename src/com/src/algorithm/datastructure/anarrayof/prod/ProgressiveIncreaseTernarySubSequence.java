package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 递增增加三元子序列
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/12
 */
public class ProgressiveIncreaseTernarySubSequence {

    public Boolean mySelf_CheckIsExistTernarySubSequence(int[] checkTernarySubSequenceArray){
        int currentFirstMin=Integer.MAX_VALUE;
        int currentSecondMin=Integer.MAX_VALUE;
        for (int checkTernarySubSequenceArrayIndex = 0; checkTernarySubSequenceArrayIndex < checkTernarySubSequenceArray.length; checkTernarySubSequenceArrayIndex++) {
            if (checkTernarySubSequenceArray[checkTernarySubSequenceArrayIndex]<=currentFirstMin) {
                currentFirstMin=checkTernarySubSequenceArray[checkTernarySubSequenceArrayIndex];
            }else if (checkTernarySubSequenceArray[checkTernarySubSequenceArrayIndex]<=currentSecondMin){
                currentSecondMin=checkTernarySubSequenceArray[checkTernarySubSequenceArrayIndex];
            }else {
                return true;
            }
        }
        return false;
    }
}
