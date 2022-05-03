package com.src.algorithm.datastructure.mathematics.test;

import com.src.algorithm.datastructure.mathematics.prod.FindTheWinnerOfTheCircularGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheWinnerOfTheCircularGameTest {
    FindTheWinnerOfTheCircularGame findTheWinnerOfTheCircularGame;
    int numberOfParticipants;
    int eliminationDigit;
    int expectedValue;

    @BeforeEach
    void setUp() {
        findTheWinnerOfTheCircularGame = new FindTheWinnerOfTheCircularGame();
        numberOfParticipants = 5;
        eliminationDigit = 2;
        expectedValue = 3;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listNodeFindTheWinnerOfTheCircularGame() {
        int winnerNumber = findTheWinnerOfTheCircularGame.listNodeFindTheWinnerOfTheCircularGame(numberOfParticipants, eliminationDigit);
        assertEquals(expectedValue, winnerNumber);
    }

    @Test
    void mySelf_SecondListNodeFindTheWinnerOfTheCircularGame() {
        int winnerNumber = findTheWinnerOfTheCircularGame.mySelf_SecondListNodeFindTheWinnerOfTheCircularGame(numberOfParticipants, eliminationDigit);
        assertEquals(expectedValue, winnerNumber);
    }
}
