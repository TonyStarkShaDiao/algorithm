package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.HashSet;

/**
 * 只有一次数量
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/18
 */
public class OnlyOnceNumber {

    /**
     * 我自己的hash方法查找只出现一次的数字
     *
     *
     * @param specifiedFindArray 查找的指定数组
     * @return int
     */
    public int mySelf_HashFindOnlyOnceNumberInArray(int [] specifiedFindArray){
        HashSet<Integer> elementSet =new HashSet<>();
        for (int specifiedFindArrayIndex = 0; specifiedFindArrayIndex < specifiedFindArray.length; specifiedFindArrayIndex++) {
            if (elementSet.contains(specifiedFindArray[specifiedFindArrayIndex])) {
                elementSet.remove(specifiedFindArray[specifiedFindArrayIndex]);
            }else {
                elementSet.add(specifiedFindArray[specifiedFindArrayIndex]);
            }
        }
    return elementSet.iterator().next();
    }

    /**
     * 自我异或只发现一次数字在数组中
     *
     * @param specifiedFindArray 找到指定数组
     * @return int
     */
    public int mySelf_ExclusiveOrFindOnlyOnceNumberInArray(int [] specifiedFindArray){
        int currentExclusiveOrValue =0;
        for (int specifiedFindArrayIndex = 0; specifiedFindArrayIndex < specifiedFindArray.length; specifiedFindArrayIndex++) {
            currentExclusiveOrValue^=specifiedFindArray[specifiedFindArrayIndex];
        }
        return currentExclusiveOrValue;
    }


}
