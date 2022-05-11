package com.src.algorithm.datastructure.graph.prod;

/**
 * 找到镇法官
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/10
 */
public class FindTheTownJudge {

    /**
     * 我自己去找镇上法官
     *
     * @param personVoteIntentionArray 个人投票意向数组 [0] 编号 [1] 投票意向
     * @param personNumber             人数
     * @return int
     */
    public int mySelf_FindTheTownJudge(int personNumber, int[][] personVoteIntentionArray) {
        int[] ballotStatistics = new int[personNumber + 1];
        for (int[] personalVote : personVoteIntentionArray) {
            ballotStatistics[personalVote[0]]--;
            ballotStatistics[personalVote[1]]++;
        }
        for (int numberOfPeople = 1; numberOfPeople <= personNumber; numberOfPeople++) {
            if (ballotStatistics[numberOfPeople] == personNumber - 1) {
                return numberOfPeople;
            }
        }
        return -1;
    }
}
