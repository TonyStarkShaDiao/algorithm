package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.*;

/**
 * 三个数之和
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/21
 */
public class ThreeNumberSum {
    public List<List<Integer>> Myself_TripleTraversalThreeNumberSum(int[] specifiedFindArray) {
        List<List<Integer>> arrayElementCollect = new ArrayList<>();
        for (int firstNumberArrayIndex = 0; firstNumberArrayIndex < specifiedFindArray.length; firstNumberArrayIndex++) {
            for (int secondNumberArrayIndex = firstNumberArrayIndex + 1; secondNumberArrayIndex < specifiedFindArray.length; secondNumberArrayIndex++) {
                for (int thirdNumberArrayIndex = secondNumberArrayIndex + 1; thirdNumberArrayIndex < specifiedFindArray.length; thirdNumberArrayIndex++) {
                    if (specifiedFindArray[firstNumberArrayIndex] + specifiedFindArray[secondNumberArrayIndex] + specifiedFindArray[thirdNumberArrayIndex] == 0) {
                        arrayElementCollect.add(Arrays.asList(specifiedFindArray[firstNumberArrayIndex], specifiedFindArray[secondNumberArrayIndex], specifiedFindArray[thirdNumberArrayIndex]));
                    }
                }
            }
        }
        return arrayElementCollect;
    }

    public List<List<Integer>> Myself_OrderTripleTraversalThreeNumberSum(int[] specifiedFindArray) {
        Set<List<Integer>> arrayElementCollect = new HashSet<>();
        Arrays.sort(specifiedFindArray);
        for (int firstNumberArrayIndex = 0; firstNumberArrayIndex < specifiedFindArray.length; firstNumberArrayIndex++) {
            for (int secondNumberArrayIndex = firstNumberArrayIndex + 1; secondNumberArrayIndex < specifiedFindArray.length; secondNumberArrayIndex++) {
                for (int thirdNumberArrayIndex = secondNumberArrayIndex + 1; thirdNumberArrayIndex < specifiedFindArray.length; thirdNumberArrayIndex++) {
                    if (specifiedFindArray[firstNumberArrayIndex] + specifiedFindArray[secondNumberArrayIndex] + specifiedFindArray[thirdNumberArrayIndex] == 0) {
                        List<Integer> temporaryList = Arrays.asList(specifiedFindArray[firstNumberArrayIndex], specifiedFindArray[secondNumberArrayIndex], specifiedFindArray[thirdNumberArrayIndex]);
                        arrayElementCollect.add(temporaryList);
                    }
                }
            }
        }
        return new ArrayList<>(arrayElementCollect);
    }

    public List<List<Integer>> Myself_DoublePointerThreeNumberSum(int[] specifiedFindArray) {
        Set<List<Integer>> arrayElementCollect = new HashSet<>();
        Arrays.sort(specifiedFindArray);
        System.out.println(Arrays.toString(specifiedFindArray));
        for (int firstNumberArrayIndex = 0; firstNumberArrayIndex < specifiedFindArray.length-2; firstNumberArrayIndex++) {
            if (firstNumberArrayIndex > 0 && specifiedFindArray[firstNumberArrayIndex] == specifiedFindArray[firstNumberArrayIndex -1]) {
                continue;
            }
            DoublePointerTwoNumberSum(specifiedFindArray, -specifiedFindArray[firstNumberArrayIndex], arrayElementCollect, firstNumberArrayIndex);
        }
        return new ArrayList<>(arrayElementCollect);
    }

    private void DoublePointerTwoNumberSum(int[] specifiedFindArray, int expectedValue, Set<List<Integer>> arrayElementCollect, int firstNumberArrayIndex) {
        int headPoint = firstNumberArrayIndex + 1;
        int tailPoint = specifiedFindArray.length - 1;
        while (headPoint < tailPoint) {
            int sum = specifiedFindArray[tailPoint] + specifiedFindArray[headPoint];
            if (sum == expectedValue) {
                arrayElementCollect.add(Arrays.asList(-expectedValue, specifiedFindArray[headPoint], specifiedFindArray[tailPoint]));
                while (headPoint < specifiedFindArray.length && specifiedFindArray[headPoint] == specifiedFindArray[++headPoint]) {
                }
                while (tailPoint < headPoint && specifiedFindArray[tailPoint] == specifiedFindArray[--tailPoint]) {
                }
            } else if (sum < expectedValue) {
                headPoint++;
            } else {
                tailPoint--;

            }
        }
    }

    public List<List<Integer>> threeSum(int[] specifiedFindArray) {
        if (specifiedFindArray == null || specifiedFindArray.length < 3)
            return new ArrayList<>();
        List<List<Integer>> arrayElementCollect = new ArrayList<>();
        Arrays.sort(specifiedFindArray);
        for (int specifiedFindArrayIndex = 0; specifiedFindArrayIndex < specifiedFindArray.length; specifiedFindArrayIndex++) {
            twoNumberSum(specifiedFindArray, -specifiedFindArray[specifiedFindArrayIndex], arrayElementCollect, specifiedFindArrayIndex);
        }
        return new ArrayList<>(arrayElementCollect); // O(n)
    }

    private void twoNumberSum(int[] specifiedFindArray, int expectedValue, List<List<Integer>> arrayElementCollect, int specifiedFindArrayIndex) {
        int headerPoint = specifiedFindArrayIndex + 1;
        int tailPoint = specifiedFindArray.length - 1;
        while (headerPoint < tailPoint) {
            int sum = specifiedFindArray[headerPoint] + specifiedFindArray[tailPoint];
            if (sum == expectedValue) {
                arrayElementCollect.add(Arrays.asList(-expectedValue, specifiedFindArray[headerPoint], specifiedFindArray[tailPoint]));
                headerPoint++;
                tailPoint--;
            } else if (sum < expectedValue) {
                headerPoint++;
            } else {
                tailPoint--;
            }
        }
    }


}
