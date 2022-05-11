package com.src.algorithm.datastructure.graph.test;

import com.src.algorithm.datastructure.graph.prod.MinimumNumberOfPointsThatCanReachAllPoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumNumberOfPointsThatCanReachAllPointsTest {

    private MinimumNumberOfPointsThatCanReachAllPoints minimumNumberOfPointsThatCanReachAllPointsUnderTest;
    private List<List<Integer>> outDegreeSpotCollect;
    private int inDegreeSpotNumber;
    private List<Integer> expectPenetrationSpotCollect;

    @BeforeEach
    void setUp() {
        minimumNumberOfPointsThatCanReachAllPointsUnderTest = new MinimumNumberOfPointsThatCanReachAllPoints();
        outDegreeSpotCollect = new ArrayList<>();
        outDegreeSpotCollect.add(Arrays.asList(0, 1));
        outDegreeSpotCollect.add(Arrays.asList(0, 2));
        outDegreeSpotCollect.add(Arrays.asList(2, 5));
        outDegreeSpotCollect.add(Arrays.asList(3, 4));
        outDegreeSpotCollect.add(Arrays.asList(4, 2));
        inDegreeSpotNumber = 6;
        expectPenetrationSpotCollect = Arrays.asList(0, 3);
    }

    @Test
    void testMyself_MinimumNumberOfPointsThatCanReachAllPoints() {
        assertThat(minimumNumberOfPointsThatCanReachAllPointsUnderTest.myself_MinimumNumberOfPointsThatCanReachAllPoints(inDegreeSpotNumber, outDegreeSpotCollect)).isEqualTo(expectPenetrationSpotCollect);
    }
}
