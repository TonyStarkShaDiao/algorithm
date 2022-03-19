package com.src.algorithm.datastructure.anarrayof.prod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 多数元素
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/03/18
 * @title
 * @describe 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MostOfElements {

    /**
     * 我自己排序寻找超过一半元素在数组中
     *
     * @param specifiedFindArray 找到指定数组
     * @return int
     */
  public   int mySelf_SortLookingForMoreThanHalfElementInArray(int[] specifiedFindArray) {
        Arrays.sort(specifiedFindArray);
        return specifiedFindArray[specifiedFindArray.length / 2];
    }

    /**
     * 我自己哈希查找一半以上元素数组
     *
     * @param specifiedFindArray 找到指定数组
     * @return int
     */
    public  int mySelf_HashLookingForMoreThanHalfElementInArray(int[] specifiedFindArray) {
        Map<Integer, Integer> elementCountContainer = new HashMap<>(specifiedFindArray.length);
        for (int i = 0; i < specifiedFindArray.length; i++) {
            if (elementCountContainer.containsKey(specifiedFindArray[i])) {
                elementCountContainer.put(specifiedFindArray[i],elementCountContainer.get(specifiedFindArray[i])+1);
            }else {
                elementCountContainer.put(specifiedFindArray[i],1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = elementCountContainer.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue()>(specifiedFindArray.length/2)){
                return  next.getKey();
            }
        }
        return 0;
    }

    public  int mySelf_MooreVoteLookingForMoreThanHalfElementInArray(int[] specifiedFindArray) {
        if (specifiedFindArray==null||specifiedFindArray.length==0){
            return Integer.MIN_VALUE;
        }
        int firstOneVoters=specifiedFindArray[0];
        int firstOneVotersTicketCount =1;
        for (int specifiedFindArrayIndex = 1; specifiedFindArrayIndex < specifiedFindArray.length; specifiedFindArrayIndex++) {
            if (firstOneVoters==specifiedFindArray[specifiedFindArrayIndex]){
                firstOneVotersTicketCount++;
            }else if (firstOneVotersTicketCount==0){
                firstOneVoters =specifiedFindArray[specifiedFindArrayIndex];
            }else {
                firstOneVotersTicketCount--;
            }
        }
        return firstOneVoters;
    }
}
