package com.src.algorithm.datastructure.anarrayof.prod;

/**
 * 字符串乘法
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/04/18
 */

public class StringMultiplication {

    public String StringMultiplication(String firstCharacterString, String secondCharacterString) {
        int m = firstCharacterString.length(), n = secondCharacterString.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (firstCharacterString.charAt(i) - '0') * (secondCharacterString.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                // 两数相乘所得到的的结果个位数
                pos[p1] += sum / 10;
                //两位相乘所得到的的十位数所放在pos数组中的位置
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String mySelf_StringMultiplication(String firstCharacterString, String secondCharacterString) {
        int firstCharacterStringLength = firstCharacterString.length(), secondCharacterStringLength = secondCharacterString.length();
        int[] multiplicationResultArray = new int[firstCharacterStringLength + secondCharacterStringLength];
        for (int firstCharacterStringIndex = firstCharacterStringLength - 1; firstCharacterStringIndex >= 0; firstCharacterStringIndex--) {
            for (int secondCharacterStringIndex = secondCharacterStringLength - 1; secondCharacterStringIndex >= 0; secondCharacterStringIndex--) {
//                相乘结果
                int multiplicationResult = (firstCharacterString.charAt(firstCharacterStringIndex) - '0') * (secondCharacterString.charAt(secondCharacterStringIndex) - '0');
//                相乘结果的个位数的位置
                int singleDigitIndex = firstCharacterStringIndex + secondCharacterStringIndex;
//                相乘结果的十位数的位置
                int tenDigitsIndex = firstCharacterStringIndex + secondCharacterStringIndex + 1;
//                相乘结果的十位数的值 要加上之前十位数余留的值
                int singleDigitResult = multiplicationResult + multiplicationResultArray[tenDigitsIndex];
//                相乘结果的个位数的值
                multiplicationResultArray[singleDigitIndex] += singleDigitResult / 10;
//                相乘结果的十位数的值
                multiplicationResultArray[tenDigitsIndex] = singleDigitResult % 10;
            }

        }
        StringBuilder stringMultiplicationResultStringBuilder = new StringBuilder();
        for (int eachDigitElement : multiplicationResultArray) {
            if (!(stringMultiplicationResultStringBuilder.length() == 0 && eachDigitElement == 0)) {
                stringMultiplicationResultStringBuilder.append(eachDigitElement);
            }
        }
        return stringMultiplicationResultStringBuilder.length() == 0 ? "0" : stringMultiplicationResultStringBuilder.toString();
    }

    public String mySelf_SecondStringMultiplication(String firstCharacterString, String secondCharacterString) {
        int firstCharacterStringLength = firstCharacterString.length();
        int secondCharacterStringLength = secondCharacterString.length();
        int[] multiplicationResultArray = new int[firstCharacterStringLength + secondCharacterStringLength];
        for (int firstCharacterStringIndex = firstCharacterStringLength - 1; firstCharacterStringIndex >= 0; firstCharacterStringIndex--) {
            for (int secondCharacterStringIndex = secondCharacterStringLength - 1; secondCharacterStringIndex >= 0; secondCharacterStringIndex--) {
                int multiplicationResult = (firstCharacterString.charAt(firstCharacterStringIndex) - '0') * (secondCharacterString.charAt(secondCharacterStringIndex) - '0');
                int singleDigitPosition = firstCharacterStringIndex + secondCharacterStringIndex;
                int tenDigitPosition = firstCharacterStringIndex + secondCharacterStringIndex + 1;
                int multiplicationResultAddPreviousTenDigitsResult = multiplicationResult + multiplicationResultArray[tenDigitPosition];
                multiplicationResultArray[singleDigitPosition] += multiplicationResultAddPreviousTenDigitsResult / 10;
                multiplicationResultArray[tenDigitPosition] = multiplicationResultAddPreviousTenDigitsResult % 10;
            }
        }
        StringBuilder stringMultiplicationResultStringBuilder = new StringBuilder();
        for (int elementsOfEachDigit : multiplicationResultArray) {
            if (!(stringMultiplicationResultStringBuilder.length() == 0 && elementsOfEachDigit == 0)) {
                stringMultiplicationResultStringBuilder.append(elementsOfEachDigit);
            }

        }
        return stringMultiplicationResultStringBuilder.length() == 0 ? "0" : stringMultiplicationResultStringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123456789");
        stringBuilder.append("123456789");
        stringBuilder.deleteCharAt(0);
        System.out.println(stringBuilder.toString());
    }

}
//12
//123
//   6
