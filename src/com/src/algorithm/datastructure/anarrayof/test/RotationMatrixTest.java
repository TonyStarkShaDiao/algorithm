package com.src.algorithm.datastructure.anarrayof.test;

import com.src.algorithm.datastructure.anarrayof.prod.RotationMatrix;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotationMatrixTest {
  RotationMatrix rotationMatrix;
  int[][]  matrixArray;
  int[][]  rotatingMatrixArray;
    @BeforeEach
    void setUp() {
        matrixArray =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotatingMatrixArray=new int[][]{{7,4,1},{8,5,2},{9,6,3}};
        rotationMatrix =new RotationMatrix();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void myself_rotateMatrix() {
        rotationMatrix.myself_rotateMatrix(matrixArray);
        assertArrayEquals(rotatingMatrixArray,matrixArray);
    }
}