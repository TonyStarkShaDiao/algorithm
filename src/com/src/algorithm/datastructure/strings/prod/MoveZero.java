package com.src.algorithm.datastructure.strings.prod;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//请注意 ，必须在不复制数组的情况下原地对数组进行操作。
public class MoveZero {

    //[1,0,3,0]
    //[1,3,0,0]
//           快
//       慢指针走的条件  快指针不等于0,并且快慢指针相等

//
    //双指针 一个指针指向0 一个指针指向最后一个元素
    //比较两个指针的值,如果指针的值为0 就交换两个指针的值
    //如果第一个指针的是不为0 就是移动第一个指针,如果第一个指针的值为0 就判断第二个指针的值是否为0,如果第二个指针的值为0 就移动第二个指针
    //直到第二个指针的值不为0 就交换两个指针的值
    //结束条件指针重合

    public void moveZeros(int[] needMoveZeroArray) {
        int headerPoint = 0;
        int tailPoint = needMoveZeroArray.length - 1;
        while (headerPoint < tailPoint) {
            if (needMoveZeroArray[headerPoint] == 0 && needMoveZeroArray[tailPoint] != 0) {
                int notZeroElement = needMoveZeroArray[tailPoint];
                needMoveZeroArray[tailPoint] = needMoveZeroArray[headerPoint];
                needMoveZeroArray[headerPoint] = notZeroElement;
                headerPoint++;
                tailPoint--;
                continue;
            }
            if (needMoveZeroArray[headerPoint] != 0) {
                headerPoint++;
            }
            if (needMoveZeroArray[tailPoint] == 0) {
                tailPoint--;
            }
        }
    }

    public void doublePointerMoveZeros(int[] needMoveZeroArray) {
        int slow = 0; // 慢指针指向下一个非零元素应该放置的位置
        for (int fast = 0; fast < needMoveZeroArray.length; fast++) {
            if (needMoveZeroArray[fast] != 0) {
                if (slow != fast) {
                    needMoveZeroArray[slow] = needMoveZeroArray[fast]; // 将非零元素移动到慢指针的位置
                    needMoveZeroArray[fast] = 0; // 将快指针的位置置为0
                }
                slow++; // 移动慢指针
            }
        }
    }

    public static void main(String[] args) {
        int[] needMoveZeroArray = new int[]{1, 0, 2, 0, 3, 0};
        MoveZero moveZero = new MoveZero();
        moveZero.doublePointerMoveZeros(needMoveZeroArray);
        for (int i : needMoveZeroArray) {
            System.out.println(i);
        }
    }
}
