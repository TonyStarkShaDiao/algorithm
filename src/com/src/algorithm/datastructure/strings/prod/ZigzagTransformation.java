package com.src.algorithm.datastructure.strings.prod;

import java.util.Arrays;

/**
 * 之字形变换
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/14
 */
public class ZigzagTransformation {

    public String mySelf_easyZigzagTransformation(String characterString, int numberOfStringLines) {
        if (numberOfStringLines == 1) {
            return characterString;
        }
        String[] stringPerColumn = new String[numberOfStringLines];
        Arrays.fill(stringPerColumn, "");
        char[] chars = characterString.toCharArray();
        int cycle = numberOfStringLines * 2 - 2;
        for (int charsIndex = 0; charsIndex < chars.length; charsIndex++) {
            int columnIndex = charsIndex % cycle;
            if (columnIndex < numberOfStringLines) {
                stringPerColumn[columnIndex] += chars[charsIndex];
            } else {
                stringPerColumn[cycle - columnIndex] += chars[charsIndex];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String columnString : stringPerColumn) {
            stringBuilder.append(columnString);
        }
        return stringBuilder.toString();
    }
}
