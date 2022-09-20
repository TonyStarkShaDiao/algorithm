package com.src.algorithm.datastructure.mathematics.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * 火柴拼正方形
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/06/01
 */
public class MatchToSquare {
    public boolean mySelf_toFlashBackMakesquare(int[] matchArray) {
        if (matchArray == null || matchArray.length < 4) {
            return false;
        }
        int totalLengthOfMatches = 0;
        for (int i = 0; i < matchArray.length; i++) {
            totalLengthOfMatches += matchArray[i];
        }
        if (totalLengthOfMatches % 4 != 0) {
            return false;
        }
        List<Integer> matchNumberAndLengthCollect = new ArrayList<>();
        for (int matchLength : matchArray) {
            matchNumberAndLengthCollect.add(matchLength);
        }
        matchNumberAndLengthCollect.sort((firstMatch, secondMatch) -> (secondMatch - firstMatch));
        int squareLength = totalLengthOfMatches / 4;
        return mySelfBacktrack(matchNumberAndLengthCollect, squareLength, 0, new int[4]);
    }

    private boolean mySelfBacktrack(List<Integer> matchNumberAndLengthCollect, int squareLength, int matchNumber, int[] sideLengthArrayOfSquares) {
        if (matchNumber == matchNumberAndLengthCollect.size()) {
            return sideLengthArrayOfSquares[0] == squareLength && sideLengthArrayOfSquares[1] == squareLength && sideLengthArrayOfSquares[2] == squareLength;

        }
        for (int i = 0; i < 4; i++) {
            if (sideLengthArrayOfSquares[i] + matchNumberAndLengthCollect.get(matchNumber) > squareLength) {
                continue;
            }
            sideLengthArrayOfSquares[i] += matchNumberAndLengthCollect.get(matchNumber);
            if (mySelfBacktrack(matchNumberAndLengthCollect, squareLength, matchNumber + 1, sideLengthArrayOfSquares)) {
                return true;
            }
            sideLengthArrayOfSquares[i] -= matchNumberAndLengthCollect.get(matchNumber);
        }
        return false;
    }

    /**
     * @param nums 数字
     * @return boolean
     */
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int quarSum = 0;
        for (int num : nums) {
            quarSum += num;
        }

        if (quarSum % 4 != 0) {
            return false;
        }

        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }

        numList.sort((o1, o2) -> (o2 - o1));

        return backtrack(numList, quarSum / 4, 0, new int[4]);
    }

    private boolean backtrack(List<Integer> nums, int target, int index, int[] sum) {
        if (index == nums.size()) {
            if (sum[0] == target && sum[1] == sum[0] && sum[2] == sum[1])
                return true;
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums.get(index) > target) {
                continue;
            }

            sum[i] += nums.get(index);
            if (backtrack(nums, target, index + 1, sum)) {
                return true;
            }

            sum[i] -= nums.get(index);
        }

        return false;
    }


}
