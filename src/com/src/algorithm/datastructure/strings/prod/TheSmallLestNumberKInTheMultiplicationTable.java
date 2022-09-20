package com.src.algorithm.datastructure.strings.prod;

public class TheSmallLestNumberKInTheMultiplicationTable {

    public int mySelf_binarySearchTheSmallLestNumberKInTheMultiplicationTable(int product, int productBy, int NumberSmallerThank) {
        int headerPoint = 1;
        int tailPoint = product * productBy;
        while (headerPoint < tailPoint) {
            int midPoint = headerPoint + ((tailPoint - headerPoint) >> 1);
            if (this.checkReachMiddlePointQuantityWhetherItMeetsRequirementsFork(product, productBy, midPoint, NumberSmallerThank)) {
                tailPoint = midPoint;
            } else {
                headerPoint = midPoint + 1;
            }
        }
        return headerPoint;
    }

    /**
     * 检查到达中点数量是否符合要求
     *
     * @param product   产品
     * @param productBy 产品制造商
     * @param midPoint  中点，中点
     * @return boolean
     */
    private boolean checkReachMiddlePointQuantityWhetherItMeetsRequirementsFork(int product, int productBy, int midPoint, int NumberSmallerThank) {
        int midPointQuantity = 0;
        for (int i = 1; i <= product; i++) {
            midPointQuantity += Math.min(midPoint / i, productBy);
        }
        return midPointQuantity >= NumberSmallerThank;
    }
}
