package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.Random;

/**
 * 查找数组中重复n次元素，长度为2m的数组
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/21
 */
public class FindTheElementsRepeatedNTimesInTheArrayWithLengthTwoM {
    public int mySelf_randomFindTheElementsRepeatedNTimesInTheArrayWithLengthTwoM(int[] array) {
        while (true) {
            int firstRandomElement = new Random().nextInt(array.length);
            int secondRandomElement = new Random().nextInt(array.length);
            if (firstRandomElement != secondRandomElement && array[firstRandomElement] == array[secondRandomElement]) {
                return array[firstRandomElement];
            }
        }
    }
}
