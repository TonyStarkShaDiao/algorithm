package com.src.algorithm.datastructure.strings.prod;

/**
 * 实现strstr
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/18
 */
public class ImplementsStrstr {
    public int mySelf_kmpImplementsStrstr(String originalString, String substringToFind) {
        int substringToFindLength = substringToFind.length();
        if (substringToFindLength == 0) {
            return 0;
        }
        return this.kmp(originalString.toCharArray(), substringToFind.toCharArray());
    }

    private int kmp(char[] originalStringCharArray, char[] substringToFindCharArray) {
        int[] partialMatchingTable = this.buildPartialMatchingTable(substringToFindCharArray);
        int originalStringCharArrayIndex = 0;
        int substringToFindCharArrayIndex = 0;
        while (originalStringCharArrayIndex < originalStringCharArray.length && substringToFindCharArrayIndex < substringToFindCharArray.length) {
            if (originalStringCharArray[originalStringCharArrayIndex] == substringToFindCharArray[substringToFindCharArrayIndex]) {
                originalStringCharArrayIndex++;
                substringToFindCharArrayIndex++;
            } else {
                if (substringToFindCharArrayIndex == 0) {
                    originalStringCharArrayIndex++;
                } else {
                    substringToFindCharArrayIndex = partialMatchingTable[substringToFindCharArrayIndex - 1] + 1;
                }
            }
        }
        return substringToFindCharArrayIndex == substringToFindCharArray.length ? (originalStringCharArrayIndex - substringToFindCharArray.length) : -1;
    }

    private int[] buildPartialMatchingTable(char[] substringToFindCharArray) {
        int[] partialMatchingTable = new int[substringToFindCharArray.length];
        partialMatchingTable[0] = -1;
        int previousMatchingIndex = 0;
        for (int substringToFindCharArrayIndex = 1; substringToFindCharArrayIndex < substringToFindCharArray.length; substringToFindCharArrayIndex++) {
            previousMatchingIndex = partialMatchingTable[substringToFindCharArrayIndex - 1];
            while (previousMatchingIndex >= 0 && substringToFindCharArray[previousMatchingIndex + 1] != substringToFindCharArray[substringToFindCharArrayIndex]) {
                previousMatchingIndex = partialMatchingTable[previousMatchingIndex];
            }
            if (substringToFindCharArray[substringToFindCharArrayIndex] == substringToFindCharArray[previousMatchingIndex + 1]) {
                partialMatchingTable[substringToFindCharArrayIndex] = previousMatchingIndex + 1;
            } else {
                partialMatchingTable[substringToFindCharArrayIndex] = -1;
            }
        }
        return partialMatchingTable;
    }
}
