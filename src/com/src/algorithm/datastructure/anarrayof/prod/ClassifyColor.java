package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 按颜色分类
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/03
 */
public class ClassifyColor {

    /**
     * 我自我三个点接口入参交换分类颜色
     * 我自己三分交换颜色进行分类
     *
     * @param threeColorArray 三个颜色数组
     */
    public void mySelf_ThreePointToSwapClassifyColor(int[] threeColorArray) {
        int headerPont=0;
        int tailPoint=threeColorArray.length-1;
        int traversePoint=0;
        while (traversePoint <= tailPoint) {
            int currentArrayElement = threeColorArray[traversePoint];
            if (currentArrayElement==0){
                this.swapArray(threeColorArray,traversePoint,headerPont);
                headerPont++;
                traversePoint++;
            }else if (currentArrayElement==1){
                traversePoint++;
            }else {
                this.swapArray(threeColorArray,traversePoint,tailPoint);
                tailPoint--;
            }
        }
    }

    private  void swapArray(int[] swapArray, int firstOneArrayIndex, int secondArrayIndex){
        int temporaryArray = swapArray[firstOneArrayIndex];
        swapArray[firstOneArrayIndex]=swapArray[secondArrayIndex];
        swapArray[secondArrayIndex]=temporaryArray;
    }

    /**
     * 我自己曾经穿过分类颜色
     * 自己的一次遍历颜色进行分类
     * 我自己 一次颜色进行分类
     *
     * @param threeColorArray 三个颜色数组
     */
    public void mySelf_OnceTraverseClassifyColor(int[] threeColorArray) {
       int zeroBorderIndex=0;
       int oneBorderIndex=0;
        for (int threeColorArrayIndex = 0; threeColorArrayIndex < threeColorArray.length; threeColorArrayIndex++) {
            int temporaryArrayElement = threeColorArray[threeColorArrayIndex];
            threeColorArray[threeColorArrayIndex]=2;
            if (temporaryArrayElement<2){
                threeColorArray[oneBorderIndex++]=1;
            }
            if (temporaryArrayElement<1) {
                threeColorArray[zeroBorderIndex++]=0;
            }
        }
    }
    }

