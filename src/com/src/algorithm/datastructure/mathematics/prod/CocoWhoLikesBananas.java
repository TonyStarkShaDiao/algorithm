package com.src.algorithm.datastructure.mathematics.prod;

/**
 * 喜欢香蕉可可
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/06/08
 */
public class CocoWhoLikesBananas {

    public int binarySearchCocoWhoLikesBananas(int[] aPileOfBananasArray, int timeToEatBananas) {
        int headerPoint = 0;
        int tailPoint = Integer.MIN_VALUE;
        for (int bananaQuantity : aPileOfBananasArray) {
            tailPoint = Math.max(tailPoint, bananaQuantity);
        }
        tailPoint++;
        while (headerPoint + 1 < tailPoint) {
            int middlePoint = ((tailPoint - headerPoint) >> 1) + headerPoint;
            if (this.isCocoWhoLikesBananas(aPileOfBananasArray, timeToEatBananas, middlePoint)) {
                headerPoint = middlePoint;
            } else {
                tailPoint = middlePoint;
            }

        }
        if (headerPoint != 0 && this.isCocoWhoLikesBananas(aPileOfBananasArray, timeToEatBananas, headerPoint)) {
            return headerPoint;
        }
        return headerPoint + 1;
    }

    private boolean isCocoWhoLikesBananas(int[] aPileOfBananasArray, int timeToEatBananas, int currentEatBananaSpeed) {
        int currentEatBananaSpeedCount = 0;
        for (int bananaQuantity : aPileOfBananasArray) {
            currentEatBananaSpeedCount += (bananaQuantity + currentEatBananaSpeed - 1) / currentEatBananaSpeed;
        }
        return currentEatBananaSpeedCount >= timeToEatBananas;
    }
}
