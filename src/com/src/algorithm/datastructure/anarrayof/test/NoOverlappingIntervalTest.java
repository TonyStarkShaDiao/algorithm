package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.NoOverlappingInterval;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;

import static org.junit.jupiter.api.Assertions.*;

class NoOverlappingIntervalTest {

    private NoOverlappingInterval noOverlappingInterval;
    int [][] intervalsArrays;
    int  expectRepetitionIntervalCount;
    @BeforeEach
    void setUp() {
        expectRepetitionIntervalCount = 1;
        noOverlappingInterval=new NoOverlappingInterval();
        intervalsArrays=new int[][]{{1,3},{2,6},{8,10},{15,18}};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void myself_NoOverlappingInterval() {
        int repetitionIntervalCount = noOverlappingInterval.myself_NoOverlappingInterval(intervalsArrays);
        assertEquals(expectRepetitionIntervalCount,repetitionIntervalCount);
    }
}