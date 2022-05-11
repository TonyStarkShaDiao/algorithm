package com.src.algorithm.datastructure.graph.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以到达所有点最小点数
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/05/10
 */
public class MinimumNumberOfPointsThatCanReachAllPoints {
    public List<Integer> myself_MinimumNumberOfPointsThatCanReachAllPoints(int numberOfPoints, List<List<Integer>> outDegreeSpotCollect) {
        List<Integer> resultSpotGraphCollect = new ArrayList<>();
        int[] pointPenetration = new int[numberOfPoints];
        for (int outDegreeSpotCollectIndex = 0; outDegreeSpotCollectIndex < outDegreeSpotCollect.size(); outDegreeSpotCollectIndex++) {
            pointPenetration[outDegreeSpotCollect.get(outDegreeSpotCollectIndex).get(1)]++;
        }
        for (int outDegreeSpotCollectIndex = 0; outDegreeSpotCollectIndex < numberOfPoints; outDegreeSpotCollectIndex++) {
            if (pointPenetration[outDegreeSpotCollectIndex] == 0) {
                resultSpotGraphCollect.add(outDegreeSpotCollectIndex);
            }
        }
        return resultSpotGraphCollect;
    }
}
