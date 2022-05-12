package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 删序造列
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/12
 */
public class DeleteColumnsToMakeSorted {

    public int mySelf_deleteColumnsToMakeSorted(String[] characterStringArray) {
        int needDeleteColumnCount = 0;
        int row = characterStringArray.length;
        int column = characterStringArray[0].length();

        for (int currentColumIndex = 0; currentColumIndex < column; currentColumIndex++) {
            for (int currentRowIndex = 1; currentRowIndex < row; ++currentRowIndex) {
                if (characterStringArray[currentRowIndex].charAt(currentColumIndex) < characterStringArray[currentRowIndex - 1].charAt(currentColumIndex)) {
                    needDeleteColumnCount++;
                    break;
                }
            }
        }
        return needDeleteColumnCount;
    }
}
